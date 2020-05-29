package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char[][] arr = new char[n][];
			for(int i = 0; i < n; ++i) {
				arr[i] = br.readLine().toCharArray();
			}
			int total = 0;
			// 한개x2가더싼경우
			if(x*2 <= y) {
				for(int i = 0; i < n; ++i) {
					for(int j = 0; j < m; ++j) {
						if(arr[i][j] == '.') {
							total += x;
						}
					}
				}
				ans.append(total).append('\n');
			}else {
				for(int i = 0; i < n; ++i) {
					for(int j = 0; j < m; ++j) {
						if(arr[i][j] == '.') {
							if(j < m-1 && arr[i][j+1] == '.') {
								total += y;
								j++;
							}else {
								total += x;
							}
						}
					}
				}
				ans.append(total).append('\n');
			}
		}
		System.out.println(ans);
	}
}
