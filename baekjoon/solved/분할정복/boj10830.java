import java.io.*;
import java.util.*;

public class boj10830 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] ret = new int[n][n];
		for(int i = 0; i < n; ++i) {
			ret[i][i] = 1;
		}
		while(b > 0) {
			long one = b % 2;
			if(one == 1) {
				ret = mul(arr, ret);
			}
			b /= 2;
			arr = mul(arr, arr);
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				ans.append(ret[i][j]).append(' ');
			}
			ans.append('\n');
		}
		System.out.println(ans);
	}
	static int[][] mul(int[][] arr1, int[][] arr2){
		int n = arr1.length;
		int[][] ret = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				int sum = 0;
				for(int k = 0; k < n; ++k) {
					sum += arr1[i][k] * arr2[k][j];
				}
				ret[i][j] = sum % 1000;
			}
		}
		return ret;
	}
}
