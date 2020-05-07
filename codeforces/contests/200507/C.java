package C;

import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			HashSet<Integer> set = new HashSet<Integer>();
			boolean check = true;
			for(int i = 0; i < n; ++i) {
				int num = (((i + arr[i]) % n) + n) % n;
				if(set.contains(num)) {
					check = false;
					break;
				}else {
					set.add(num);
				}
			}
			if(check) {
				answer.append("YES\n");
			}else {
				answer.append("NO\n");
			}
		}
		System.out.println(answer);
	}
}
