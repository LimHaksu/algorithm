import java.util.*;
class Solution {
	HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
	int answer = 0;
	public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i < edge.length; ++i) {
        	if(!map.containsKey(edge[i][0])) {
        		map.put(edge[i][0],new HashSet<Integer>());
        	}
        	map.get(edge[i][0]).add(edge[i][1]);
        	if(!map.containsKey(edge[i][1])) {
        		map.put(edge[i][1],new HashSet<Integer>());
        	}
        	map.get(edge[i][1]).add(edge[i][0]);
        }
        bfs(n,edge,visited);
        return answer;
    }
    void bfs(int n, int[][] edge, boolean[] visited) {
    	int current = 1;
    	visited[1] = true;
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(current);
    	while(!q.isEmpty()) {
    		int size = q.size();
   			answer = size;
    		for(int i = 0; i < size; ++i) {
    			current = q.remove();
    			for(int next : map.get(current)) {
    				if(!visited[next]) {
    					visited[next] = true;
    					q.add(next);
    				}
    			}
    		}
    	}
    }
}
public class 가장_먼_노드 {
	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		Solution sol = new Solution();
		System.out.println(sol.solution(n, vertex));
	}
}
