import java.io.*;
import java.util.*;

public class boj11054 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp1 = new int[n+2];
		int[] dp2 = new int[n+2];
		
		for(int i = 1; i <= n; ++i) {
			int max = 0;
			int maxIndex = 0;
			for(int j = 1; j < i; ++j) {
				if(arr[j] < arr[i] && dp1[j] > max) {
					max = dp1[j];
					maxIndex = j;
				}
			}
			dp1[i] = dp1[maxIndex] + 1;
		}
		for(int i = n; i >= 0; --i) {
			int max = 0;
			int maxIndex = n+1;
			for(int j = n; j > i; --j) {
				if(arr[j] < arr[i] && dp2[j] > max) {
					max = dp2[j];
					maxIndex = j;
				}
			}
			dp2[i] = dp2[maxIndex] + 1;
		}
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			int sum = dp1[i] + dp2[i] - 1;
			if(sum > ans) {
				ans = sum;
			}
		}
		System.out.println(ans);
	}
}
