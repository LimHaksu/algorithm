public class 타겟_넘버 {
	static
	class Solution {
		static int answer = 0;
		static int targetG;
	    public int solution(int[] numbers, int target) {
	    	targetG = target;
	    	dfs(numbers,0,0);
	    	return answer;
	    }
	    void dfs(int[] numbers, int sum, int idx) {
	    	if(idx == numbers.length) {
	    		if(sum == targetG) {
	    			answer++;
	    		}
	    		return;
	    	}
	    	dfs(numbers,sum+numbers[idx], idx+1);
	    	dfs(numbers,sum-numbers[idx], idx+1);
	    }
	}
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		Solution sol = new Solution();
		System.out.println(sol.solution(numbers, target));
	}
}
