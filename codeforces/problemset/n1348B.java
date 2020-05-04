package B;

import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				set.add(arr[i]);
			}
			if (set.size() > k) {
				answer.append("-1\n");
				continue;
			}
			StringBuilder sb = new StringBuilder();
			answer.append(n*k).append('\n');
			while (n-- > 0) {
				for (int num : set) {
					sb.append(num).append(' ');
				}
				for (int i = 0; i < k - set.size(); ++i) {
					sb.append("1 ");
				}
			}
			answer.append(sb).append('\n');
		}
		System.out.println(answer);
	}
}
