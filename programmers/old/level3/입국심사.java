class Solution {
    public long solution(int n, int[] times) {
    	long answer = 0;
        long left = 1;
        long right = 1000000000000000000L; 
        while(left <= right) {
        	long mid = (left+right)/2;
        	long sum = 0;
        	for(int i = 0; i < times.length; ++i) {
        		sum += mid/times[i];
        	}
        	if(sum >= n) {
        		answer = mid;
        		right = mid-1;
        	}else {
        		left = mid+1;
        	}
        }
        return answer;
    }	
}
public class 입국심사 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 6;
		int[] times = {7,10};
		System.out.println(sol.solution(n, times));
	}
}
