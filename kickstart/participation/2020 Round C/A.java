package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for(int i = 1; i < n-1; ++i) {
				if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
					count++;
				}
			}
			ans.append("Case #"+tc+": "+count+"\n");
		}
		System.out.println(ans);
	}
}
