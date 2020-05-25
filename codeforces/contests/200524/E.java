package E;

import java.io.*;
import java.util.*;
public class E {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; ++i) {
				String line = br.readLine();
				for(int j = 0; j < n; ++j) {
					arr[i][j] = line.charAt(j)-'0';
				}
			}
			boolean check = true;
			f: for(int i = 0; i < n-1; ++i) {
				for(int j = 0; j < n-1; ++j) {
					if(arr[i][j] == 1) {
						if(arr[i+1][j] == 1 || arr[i][j+1] == 1) {
							// ok
						}else {
							check = false;
							break f;
						}
					}
				}
			}if(check) {
				ans.append("YES\n");
			}else {
				ans.append("NO\n");
			}
		}
		System.out.println(ans);
	}
}
