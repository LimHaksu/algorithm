package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long d = Long.parseLong(st.nextToken());
			long[] arr = new long[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n;++i) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			long[] arr2 = new long[n];
			long next = d;
			for(int i = n-1; i >= 0; --i) {
				long current = arr[i];
				long left = 1;
				long right = 1000000000000L/current + 1;
				while(left <= right) {
					long mid = (left+right)/2;
					if(current * mid <= next) {
						arr2[i] = current * mid;
						left = mid + 1;
					}else {
						right = mid - 1;
					}
				}
				next = arr2[i];
			}
			answer.append("Case #"+tc+": "+arr2[0]+"\n");
		}
		System.out.println(answer);
	}
}
