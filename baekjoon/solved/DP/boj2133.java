import java.io.*;
import java.util.*;

public class boj2133 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n%2==1) {
			System.out.println(0);
		}else {
			int[] dp = new int[31];
			dp[2] = 3;
			for(int i = 4; i <= n; i+=2) {
				dp[i] += dp[i-2]*3;
				for(int j = 4; j <= i; j+=2) {
					dp[i] += dp[i-j]*2;
				}
				dp[i] += 2;
			}
			System.out.println(dp[n]);
		}
	}
}
