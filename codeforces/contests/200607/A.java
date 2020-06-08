package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			boolean[][] check = new boolean[n][m];
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j =  0; j < m; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						for(int o = 0; o < n; ++o) {
							check[o][j] = true;
						}
						for(int p = 0; p < m; ++p) {
							check[i][p] = true;
						}
					}
				}
			}
			int aCount = 0;
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(!check[i][j]) {
						aCount++;
						for(int o = 0; o < n; ++o) {
							check[o][j] = true;
						}
						for(int p = 0; p < m; ++p) {
							check[i][p] = true;
						}
					}
				}
			}
			if(aCount % 2 == 0) {
				ans.append("Vivek\n");
			}else {
				ans.append("Ashish\n");
			}
		}
		System.out.print(ans);
	}
}
