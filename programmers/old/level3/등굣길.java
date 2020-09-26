class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] check = new boolean[n+1][m+1];
        for(int i = 0; i < puddles.length; ++i) {
        	check[puddles[i][1]][puddles[i][0]] = true;
        }
        int[][] area = new int[n+1][m+1];
        for(int i = 1; i <=n; ++i) {
        	if(check[i][1]) {
        		break;
        	}else {
        		area[i][1] = 1;
        	}
        }
        for(int j = 1; j <= m; ++j) {
        	if(check[1][j]) {
        		break;
        	}else {
        		area[1][j] = 1;
        	}
        }
        for(int i = 2; i <= n; ++i) {
        	for(int j = 2; j <= m; ++j) {
        		if(!check[i][j]) {
        			area[i][j] = (area[i-1][j] + area[i][j-1])%1000000007;
        		}
        	}
        }
        return area[n][m];
    }
}
public class 등굣길 {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		Solution sol = new Solution();
		System.out.println(sol.solution(m, n, puddles));
	}
}
