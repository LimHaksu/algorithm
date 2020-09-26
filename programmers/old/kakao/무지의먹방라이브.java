import java.io.*;
import java.util.*;

class Node{
	int idx, remainTime;
	Node(int idx, int remainTime){
		this.idx = idx;
		this.remainTime = remainTime;
	}
	public String toString() {
		return "("+idx+","+remainTime+")";
	}
}

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        Node[] nodes = new Node[food_times.length];
        for(int i = 0; i < food_times.length; ++i) {
        	nodes[i] = new Node(i+1, food_times[i]);
        }
        Arrays.sort(nodes,new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.remainTime, o2.remainTime);
			}
        });
        int removeTime = -1;
        System.out.println(Arrays.toString(nodes));
        if(k >= (long) nodes[0].remainTime * nodes.length) {
        	k -= (long) nodes[0].remainTime * nodes.length;
        	removeTime = nodes[0].remainTime;
        	for(int i = 1; i < nodes.length; ++i) {
            	if(k >= (long)(nodes[i].remainTime-nodes[i-1].remainTime) * (nodes.length-i)) {
            		k -= (long) (nodes[i].remainTime-nodes[i-1].remainTime) * (nodes.length-i);
            		removeTime = nodes[i].remainTime;
            		System.out.println("k "+k);
            	}else{
            		break;
            	}
            }
        }
        System.out.println("removed "+removeTime);
        ArrayList<Node> newArr = new ArrayList<>();
        for(int i = 0; i < nodes.length; ++i) {
        	nodes[i].remainTime -= removeTime;
        	if(nodes[i].remainTime > 0) {
        		newArr.add(nodes[i]);
        	}
        }
        newArr.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.idx, o2.idx);
			}
        });
        System.out.println(newArr);
        if(newArr.size() > 0) {
        	answer = newArr.get((int)(k % (long)(newArr.size()))).idx;
        }else {
        	answer = -1;
        }
        return answer;
    }
}

public class 무지의먹방라이브 {
	public static void main(String[] args) {
		int[] food_times = {3,1,2} ;
		long k = 2;
		Solution sol = new Solution();
		System.out.println(sol.solution(food_times, k));
	}
}
