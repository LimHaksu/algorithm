import java.util.*;
public class 행렬의_곱셈 {
	static
	class Solution {
	    public int[][] solution(int[][] arr1, int[][] arr2) {
	        int[][] answer = new int[arr1.length][arr2[0].length];
	        for(int i = 0; i < arr1.length; ++i) {
	        	for(int j = 0; j < arr2[0].length; ++j) {
	        		int sum = 0;
	        		for(int k = 0; k < arr1[0].length; ++k) {
	        			sum += arr1[i][k] * arr2[k][j];
	        		}
	        		answer[i][j] = sum;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		Solution sol = new Solution();
		int[][] ans = sol.solution(arr1, arr2);
		for(int i = 0; i < arr1.length; ++i) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}
}
