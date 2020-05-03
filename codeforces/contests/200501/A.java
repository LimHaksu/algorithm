package A;

import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int c = 2;
			int a = 0, b = 0;
			int[] arr = new int[n];
			for(int i = 0; i < n; ++i) {
				arr[i] = c;
				c*=2;
			}
			a = arr[n-1];
			for(int i = 0; i < n/2-1; ++i) {
				a += arr[i];
			}
			for(int i = n/2-1; i < n-1; ++i) {
				b += arr[i];
			}
			int an = a > b ? a-b : b-a;
			ans.append(an).append('\n');
		}
		System.out.println(ans);
	}
}
