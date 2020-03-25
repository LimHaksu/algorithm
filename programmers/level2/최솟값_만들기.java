import java.util.*;

public class 최솟값_만들기 {
	static
	class Solution
	{
	    public int solution(int []A, int []B)
	    {
	    	Arrays.sort(A);
	    	Arrays.sort(B);
	    	int ans = 0;
	    	for(int i = 0; i < A.length; ++i) {
	    		ans += A[i] * B[B.length-1-i];
	    	}
	    	return ans;
	    }
	}
	public static void main(String[] args) {
		int[] a = {1,4,2};
		int[] b = {5,4,4};
		Solution sol = new Solution();
		System.out.println(sol.solution(a, b));
	}
}
