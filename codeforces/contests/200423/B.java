package B;

import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n+2];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] peak = new boolean[n+2];
			for(int i = 2; i < n; ++i) {
				if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
					peak[i] = true;
				}
			}
			int count = 0;
			for(int i = 2; i <= k-1; ++i) {
				if(peak[i]) {
					count++;
				}
			}
			int max = count;
			int idx = 1;
			for(int i = k; i <= n; ++i) {
				if(peak[i-k+2]) {
					count--;
				}
				if(peak[i]) {
					count++;
				}
				if(count > max) {
					max = count;
					idx = i-k+2;
				}
			}
			ans.append(max+1).append(' ').append(idx).append('\n');
		}
		System.out.println(ans);
	}
}
