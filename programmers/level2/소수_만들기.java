public class 소수_만들기 {
	static
	class Solution {
		static boolean[] primeCheck = new boolean[3000];
		static boolean[] prime = new boolean[3000];
		static int answer = 0;
	    public int solution(int[] nums) {
	        for(int i = 2; i < primeCheck.length; ++i) {
	        	if(!primeCheck[i]) {
	        		prime[i] = true;
	        		for(int j = i; j < primeCheck.length; j += i) {
	        			primeCheck[j] = true;
	        		}
	        	}
	        }
	        comb(nums, 0, 0, 0);
	        return answer;
	    }
	    static void comb(int[] nums, int sum, int idx, int count) {
	    	if(count == 3) {
	    		if(prime[sum]) {
	    			answer++;
	    		}
	    		return;
	    	}
	    	if(idx == nums.length) return;
	    	comb(nums, sum + nums[idx], idx+1, count+1);
	    	comb(nums, sum ,idx+1,count);
	    }
	}
	public static void main(String[] args) {
		int[] nums = {1,2,4};
		Solution sol = new Solution();
		System.out.println(sol.solution(nums));
	}
}
