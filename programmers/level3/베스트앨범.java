import java.util.*;
class Solution {
	class Node implements Comparable<Node>{
		int numOfPlay;
		int idx;
		Node(int numOfPlay, int idx){
			this.numOfPlay = numOfPlay;
			this.idx = idx;
		}
		public int compareTo(Node o) {
			if(this.numOfPlay > o.numOfPlay) {
				return -1;
			}else if(this.numOfPlay < o.numOfPlay) {
				return 1;
			}
			return Integer.compare(this.idx, o.idx);
		}
	}
	class Jenre implements Comparable<Jenre>{
		int count = 0;
		PriorityQueue<Node> nodes = new PriorityQueue<>();

		@Override
		public int compareTo(Jenre o) {
			return Integer.compare(o.count,  this.count);
		}
		
	}
	public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Jenre> map = new HashMap<>();
        for(int i = 0;i  < genres.length; ++i) {
        	if(!map.containsKey(genres[i])) {
        		map.put(genres[i], new Jenre());
        	}
        	map.get(genres[i]).nodes.add(new Node(plays[i],i));
        	map.get(genres[i]).count += plays[i];
        }
        ArrayList<Jenre> arr = new ArrayList<>();
        for(Jenre j : map.values()) {
        	arr.add(j);
        }
        Collections.sort(arr);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Jenre j : arr) {
        	int idx = 0;
        	while(!j.nodes.isEmpty() && idx < 2) {
        		ans.add(j.nodes.poll().idx);
        		idx++;
        	}
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < answer.length; ++i) {
        	answer[i] = ans.get(i);
        }
        return answer;
    }
}
public class 베스트앨범 {
	public static void main(String[] args) {
		Solution sol = new Solution();
//		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		String[] genres = {"classic", "pop", "classic", "classic"};
//		int[] plays = {500,600,150,800,2500};
		int[] plays = {500, 600, 150, 800};
		System.out.println(Arrays.toString(sol.solution(genres, plays)));
	}
}
