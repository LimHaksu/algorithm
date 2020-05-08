package C;

import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[0];
			long sum = 0;
			boolean currentPlus = true;
			if (arr[0] > 0)
				currentPlus = true;
			else
				currentPlus = false;
			for (int i = 1; i < arr.length; ++i) {
				if (arr[i] > 0) {
					if (currentPlus) {
						if (arr[i] > max) {
							max = arr[i];
						}
					} else {
						sum += max;
						max = arr[i];
						currentPlus = true;
					}
				} else {
					if (currentPlus) {
						sum += max;
						max = arr[i];
						currentPlus = false;
					} else {
						if (arr[i] > max) {
							max = arr[i];
						}
					}
				}
			}
			sum += max;
			ans.append(sum).append('\n');
		}
		System.out.println(ans);
	}
}
