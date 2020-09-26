class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; ++i) {
        	dp[i][0] = dp[i-1][0] + triangle[i][0];
        	for(int j = 1; j < triangle[i].length-1; ++j) {
        		dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
        	}
        	dp[i][triangle[i].length-1] = dp[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
        }
        for(int j = 0; j < triangle[triangle.length-1].length; ++j) {
        	if(dp[triangle.length-1][j] > answer) {
        		answer = dp[triangle.length-1][j];
        	}
        }
        return answer;
    }
}
public class 정수_삼각형 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		Solution sol = new Solution();
		System.out.println(sol.solution(triangle));
	}
}
