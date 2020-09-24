import java.io.*;
import java.util.*;
public class boj12865 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		int[][] dp = new int[n+1][100001];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j <= k; ++j) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j],  dp[i-1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
