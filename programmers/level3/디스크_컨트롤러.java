import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]) {
					return -1;
				}else if(o1[1] > o2[1]) {
					return 1;
				}else {
					return Integer.compare(o1[0],  o2[0]);
				}
			}
		});
        Arrays.sort(jobs, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		if(o1[0] < o2[0]) {
        			return -1;
        		}else if(o1[0] > o2[0]) {
        			return 1;
        		}else {
        			return 0;
        		}
        	}
        });
        int currentTime = 0;
        int count = 0;
        while(count < jobs.length || !pq.isEmpty()) {
        	while(count < jobs.length && currentTime >= jobs[count][0]) {
        		pq.add(jobs[count++]);
        	}
        	
        	if(!pq.isEmpty()) {
        		int[] job = pq.poll();
        		answer += currentTime-job[0]+job[1];
        		currentTime += job[1];
        	}else {
        		currentTime = jobs[count][0];
        	}
        }
        return answer/jobs.length;
    }
}
public class 디스크_컨트롤러 {
	public static void main(String[] args) {
//		int[][] jobs = {{0,3},{1,9},{2,6}};
		int[][] jobs = {{1,3},{2,3}};
		Solution sol = new Solution();
		System.out.println(sol.solution(jobs));
	}
}
