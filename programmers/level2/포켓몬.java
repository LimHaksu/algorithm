import java.util.*;

public class 포켓몬 {
	static
	class Solution {
	    public int solution(int[] nums) {
	        int answer = 0;
	        HashSet<Integer> set = new HashSet<>();
	        for(int i = 0; i < nums.length; ++i) {
	        	set.add(nums[i]);
	        }
	        return set.size() < nums.length/2 ? set.size() : nums.length/2;
	    }
	}
	public static void main(String[] args) {
		int[] nums = {3,1,2,3};
		Solution sol = new Solution();
		System.out.println(sol.solution(nums));
	}
}
