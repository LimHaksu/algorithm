import java.io.*;
import java.util.*;
class Solution {
	class Node{
		char c;
		HashMap<Integer, Integer> remainCnt = new HashMap<>();
		HashMap<Character, Node> next = new HashMap<>();
		Node(char c){
			this.c = c;
		}
	}
    public int[] solution(String[] words, String[] queries) {
        // 앞에서부터 trie 만듦
        Node fromFront = new Node(' ');
        for(int i = 0; i < words.length; ++i) {
        	String word = words[i];
        	Node currentNode = fromFront;
        	int remain = word.length();
    		if(!currentNode.remainCnt.containsKey(remain)) {
    			currentNode.remainCnt.put(remain, 0);
    		}
    		currentNode.remainCnt.put(remain, currentNode.remainCnt.get(remain)+1);
        	for(int j = 0; j < word.length(); ++j) {
        		remain = word.length()-j-1;
        		char c = word.charAt(j);
        		if(!currentNode.next.containsKey(c)) {
        			currentNode.next.put(c,new Node(c));
        		}
        		currentNode = currentNode.next.get(c);
        		if(!currentNode.remainCnt.containsKey(remain)) {
        			currentNode.remainCnt.put(remain, 0);
        		}
        		currentNode.remainCnt.put(remain, currentNode.remainCnt.get(remain)+1);
        	}
        }
        
        // 뒤에서부터 trie 만듦
        Node fromRear = new Node(' ');
        for(int i = words.length-1; i >= 0; --i) {
        	String word = words[i];
        	Node currentNode = fromRear;
        	int remain = word.length();
    		if(!currentNode.remainCnt.containsKey(remain)) {
    			currentNode.remainCnt.put(remain, 0);
    		}
    		currentNode.remainCnt.put(remain, currentNode.remainCnt.get(remain)+1);
        	for(int j = word.length()-1; j >= 0; --j) {
        		remain = j;
        		char c = word.charAt(j);
        		if(!currentNode.next.containsKey(c)) {
        			currentNode.next.put(c,new Node(c));
        		}
        		currentNode = currentNode.next.get(c);
        		if(!currentNode.remainCnt.containsKey(remain)) {
        			currentNode.remainCnt.put(remain, 0);
        		}
        		currentNode.remainCnt.put(remain, currentNode.remainCnt.get(remain)+1);
        	}
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; ++i) {
        	String query = queries[i];
        	// 앞이 ? 인경우
        	Node currentNode;
        	int remain = 0;
        	boolean find = true;
        	
        	if(query.charAt(0)=='?') {
        		currentNode = fromRear;
        		int j = query.length()-1;
        		for(; j >= 0; --j) {
        			char c = query.charAt(j);
        			if(currentNode.next.containsKey(c)) {
        				currentNode = currentNode.next.get(c);
        			}else {
        				if(c!='?') {
        					find = false;
            			}
        				break;
        			}
        		}
        		if(find) {
        			remain = j+1;
        		}
        	}else { // 뒤가 ? 인 경우
        		currentNode = fromFront;
        		int j = 0;
        		for(; j < query.length(); ++j) {
        			char c = query.charAt(j);
        			if(currentNode.next.containsKey(c)) {
        				currentNode = currentNode.next.get(c);
        			}else {
        				if(c!='?') {
        					find = false;
            			}
        				break;
        			}
        		}
        		if(find) {
        			remain = query.length()-j;
        		}
        	}
    		if(!currentNode.remainCnt.containsKey(remain)) {
    			currentNode.remainCnt.put(remain, 0);
    		}
        	answer[idx++] = currentNode.remainCnt.get(remain);
        }
        return answer;
    }
}
public class 가사검색 {
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"?????"};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(words, queries)));
	}
}
