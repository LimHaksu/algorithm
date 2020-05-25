package B;

import java.io.*;
import java.util.*;
public class B {
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
			Arrays.sort(arr);
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < n-1; ++i) {
				int diff = arr[i+1]-arr[i];
				if(diff < min) {
					min = diff;
				}
			}
			ans.append(min).append('\n');
		}
		System.out.println(ans);
	}
}
