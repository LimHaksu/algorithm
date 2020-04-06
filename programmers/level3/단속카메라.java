import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		return Integer.compare(a[0],  b[0]);
        	}
		});
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		return Integer.compare(a[1],  b[1]);
        	}
        });
        int idx = 0;
        while(idx < routes.length) {
        	if(!pq.isEmpty()) {
	        	if(routes[idx][0] < pq.element()[1]) {
	        		pq.add(routes[idx++]);
	        	}else if(routes[idx][0] > pq.element()[1]) {
	        		answer++;
	        		while(!pq.isEmpty()) {
	        			pq.remove();
	        		}
	        	}else {
	        		while(routes[idx][0] == pq.element()[1]) {
	        			idx++;
	        		}
	        		answer++;
	        		while(!pq.isEmpty()) {
	        			pq.remove();
	        		}
	        	}
        	}else {
        		pq.add(routes[idx++]);
        	}
        }
        answer++;
        return answer;
    }
}
public class 단속카메라 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(sol.solution(routes));
	}
}
