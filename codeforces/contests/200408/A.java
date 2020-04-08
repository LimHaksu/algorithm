package A;

import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			char[][] arr = new char[n][m];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if ((i + j) % 2 == 0) {
						arr[i][j] = 'B';
					} else {
						arr[i][j] = 'W';
					}
				}
			}
			if ((n * m) % 2 == 0) {
				if (arr[n - 1][0] == 'W') {
					arr[n - 1][0] = 'B';
				} else {
					arr[n - 1][1] = 'B';
				}
			}
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
			ans.append(sb);
		}
		System.out.println(ans);
	}
}
