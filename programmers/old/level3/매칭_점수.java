import java.io.*;

import java.util.*;

class Solution {
	class Page implements Comparable<Page>{
		int index;
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		String url;
		double score = 0.0;
		double linkScore = 0.0;
		HashSet<String> linkTo = new HashSet<String>();
		HashSet<String> linkFrom = new HashSet<String>();
		
		Page(int index, String url){
			this.index = index;
			this.url = url;
		}
		public int compareTo(Page o) {
			if(this.score + this.linkScore > o.score + o.linkScore) {
				return -1;
			}else if(this.score + this.linkScore < o.score + o.linkScore) {
				return 1;
			}
			return Integer.compare(this.index, o.index);
		}
		public String toString() {
			return ""+this.index + ", " +this.url+": " + this.score + " , "+this.linkScore ;
		}
	}
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        HashMap<String, Page> pageMap = new HashMap<String, Solution.Page>();
        for(int i = 0; i < pages.length; ++i) {
        	String pageString = pages[i].toLowerCase();
        	String[] arr = pageString.split("<meta");
        	String url = null;
        	for(int j = 0; j < arr.length; ++j) {
        		String[] arr2 = arr[j].split("content=\"");
        		if(arr2.length > 1) {
        			url = arr2[1].split("\"/>")[0];
        			if(!pageMap.containsKey(url)) {
        				pageMap.put(url, new Page(i, url));
        			}else {
        				pageMap.get(url).index = i;
        			}
        		}
        	}
        	// 단어 세기
        	String[] words = pageString.split("[^a-z]");
        	for(String w : words) {
        		if(w.equals(word)) {
        			pageMap.get(url).score += 1;
        		}
        	}
        	String[] links = pageString.split("<a href=\"");
        	for(int j = 1; j < links.length; ++j) {
        		String linkTo = links[j].split("\">")[0];
        		pageMap.get(url).linkTo.add(linkTo);
        		if(!pageMap.containsKey(linkTo)) {
    				pageMap.put(linkTo, new Page(-1, linkTo));
    			}
        		pageMap.get(linkTo).linkFrom.add(url);
        	}
        }
        for(Page p : pageMap.values()) {
        	for(String linkTo : p.linkTo) {
        		pageMap.get(linkTo).linkScore += p.score / p.linkTo.size();
        	}
        }
        PriorityQueue<Page> pq = new PriorityQueue<>();
        for(Page p : pageMap.values()) {
        	pq.add(p);
        }
        while(!pq.isEmpty()) {
        	Page p = pq.remove();
        	if(p.index >= 0) {
        		return p.index;
        	}
        }
        return -1;
    }
}
public class 매칭_점수 {
	public static void main(String[] args) {
		String word = "blind";
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
//		String word = "Muzi";
//		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		Solution sol = new  Solution();
		System.out.println(sol.solution(word, pages));
	}
}
