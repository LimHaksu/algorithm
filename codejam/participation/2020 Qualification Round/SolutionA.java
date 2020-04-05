package codejam;

import java.util.*;
import java.io.*;
public class SolutionA {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int k = 0;
			for(int i = 0; i < n; ++i) {
				k += arr[i][i];
			}
			int r = 0;
			f: for(int i = 0; i < n; ++i) {
				HashSet<Integer> set = new HashSet<>();
				for(int j = 0; j < n; ++j) {
					if(!set.contains(arr[i][j])) {
						set.add(arr[i][j]);
					}else {
						r++;
						continue f;
					}
				}
			}
			int c = 0;
			f: for(int j = 0; j < n; ++j) {
				HashSet<Integer> set = new HashSet<>();
				for(int i = 0; i < n; ++i) {
					if(!set.contains(arr[i][j])) {
						set.add(arr[i][j]);
					}else {
						c++;
						continue f;
					}
				}
			}
			ans.append("Case #"+tc+": "+k+" "+r+" "+c+"\n");
		}
		System.out.println(ans);
	}
}
