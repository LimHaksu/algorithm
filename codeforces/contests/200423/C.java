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
			int[] index = new int[n+1];
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				index[arr[i]] = i;
			}
			boolean[] visited = new boolean[n];
			int current = 1;
			boolean check = true;
			w: while(current <= n) {
				int cIdx = index[current];
				visited[cIdx] = true;
				while(cIdx < n-1) {
					cIdx++;
					if(!visited[cIdx]) {
						if(arr[cIdx] == current+1) {
							visited[cIdx] = true;
							current++;
						}else {
							check = false;
							break w;
						}
					}else {
						break;
					}
				}
				current++;
			}
			if(check) {
				ans.append("YES\n");
			}else {
				ans.append("NO\n");
			}
		}
		System.out.println(ans);
	}
}
