package C;

import java.io.*;
import java.util.*;
public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		long[] sum = new long[62];
		long num = 1;
		sum[1] = 1;
		for(int i = 2; i <= 61; ++i) {
			num *= 2;
			sum[i] = sum[i-1]+num; 
		}
		for(int tc = 1; tc <= t; ++tc) {
			long n = Long.parseLong(br.readLine());
			long a = 0;
			while(n>0) {
				long temp = 1;
				int idx = 1;
				while(temp <= n) {
					temp *= 2;
					idx++;
				}
				idx--;
				temp /= 2;
				a += sum[idx];
				n -= temp;
			}
			ans.append(a).append('\n');
		}
		System.out.println(ans);
	}
}
