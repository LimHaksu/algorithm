package A3;

import java.io.*;
import java.util.*;

class Node{
	int num;
	List<Node> connect = new ArrayList<>();
	Node(int num){
		this.num = num;
	}
}
class Solution {
	boolean[] visited;
	int n;
	Node[] nodes;
    public int solution(int nn, int[][] edges) {
        int answer = 0;
        n = nn;
        visited = new boolean[n+1];
        nodes = new Node[n+1];
        for(int i = 1; i <= n; ++i) {
        	nodes[i] = new Node(i);
        }
        for(int i = 0; i < edges.length; ++i) {
        	int from = edges[i][0];
        	int to = edges[i][1];
        	nodes[from].connect.add(nodes[to]);
        	nodes[to].connect.add(nodes[from]);
        }
        int[][] far = findFarTwoNodeIdx(1);
        int a1 = far[0][0];
        far = findFarTwoNodeIdx(a1);
        a1 = far[0][0];
        answer = far[1][1];
        far = findFarTwoNodeIdx(a1);
        int answer2 = far[1][1];
        if(answer2 > answer) {
        	answer = answer2;
        }
        return answer;
    }
    int[][] findFarTwoNodeIdx(int idx) {
    	Stack<int[]> stack = new Stack<>();
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(idx);
    	visited = new boolean[n+1];
    	visited[idx] = true;
    	int dist = 0;
    	while(!q.isEmpty()) {
    		dist++;
    		int qsize = q.size();
    		for(int i = 0; i < qsize; ++i) {
    			int current = q.poll();
    			for(Node next : nodes[current].connect) {
    				if(!visited[next.num]) {
    					visited[next.num] = true;
    					stack.push(new int[] {next.num, dist});
    					q.add(next.num);
    				}
    			}
    		}
    	}
    	int[] far1 = stack.pop();
    	int[] far2 = stack.pop();
    	return new int[][] {far1, far2};
    }
}
public class A3 {
	public static void main(String[] args) throws Exception{
		int n = 3;
		int[][] edges = {{1,2},{2,3}};
		Solution sol = new Solution();
		System.out.println(sol.solution(n, edges));
	}
}
