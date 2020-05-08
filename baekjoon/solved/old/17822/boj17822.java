package boj;

import java.io.*;
import java.util.*;
public class boj17822{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][m];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] index = new int[n+1];
//		print(arr);
		for(int tc = 1; tc <=t; ++tc) {
//			System.out.println("--------------");
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= n; ++i) {
				if(i%x == 0) {
					if(d==0) {
						index[i] -= k;
						if(index[i] < 0) {
							index[i] += m;
						}
					}else {
						index[i] += k;
						if(index[i] >= m) {
							index[i] -= m;
						}
					}
				}
			}
			// 같은 원판에서 인접한거 있는지 체크
			boolean[][] check = new boolean[n+1][m];
			int count = 0;
			for(int i = 1; i <= n; ++i) {
				for(int j = 0 ; j < m; ++j) {
					int idx1 = index[i] + j;
					if(idx1 >= m) idx1 -= m;
					if(idx1 < m-1) {
						if(arr[i][idx1] > 0 && arr[i][idx1] == arr[i][idx1+1]) {
							check[i][idx1] = true;
							check[i][idx1+1] = true;
							count++;
						}
					}else {
						if(arr[i][idx1] > 0 && arr[i][0] == arr[i][idx1]) {
							check[i][0] = true;
							check[i][idx1] = true;
							count++;
						}
					}
				}
			}
			// 원판 위아래끼리 인접한거 있는지 체크
			for(int j = 0; j < m; ++j) {
				for(int i = 1; i < n; ++i) {
					int idx1 = index[i]+j;
					if(idx1 >= m) idx1 -= m;
					int idx2 = index[i+1]+j;
					if(idx2 >= m) idx2 -= m;
					if(arr[i][idx1] > 0 && arr[i][idx1] == arr[i+1][idx2]) {
						check[i][idx1] = true;
						check[i+1][idx2] = true;
						count++;
					}
				}
			}
			// 같은 수 존재
			if(count>0) {
				for(int j = 0; j < m; ++j) {
					for(int i = 1; i <= n; ++i) {
						int idx1 = index[i]+j;
						if(idx1 >= m) idx1 -= m;
						if(check[i][idx1]) {
							arr[i][idx1] = 0;
						}
					}
				}
			}else {
				// 같은수 없음
				int sum = 0;
				int sumCount = 0;
				for(int j = 0; j < m; ++j) {
					for(int i = 1; i <= n; ++i) {
						int idx1 = index[i]+j;
						if(idx1 >= m) idx1 -= m;
						if(arr[i][idx1] > 0 && !check[i][idx1]) {
							sum += arr[i][idx1];
							sumCount++;
						}
					}
				}
				double average = (double)sum/sumCount;
				for(int j =0; j < m; ++j) {
					for(int i = 1; i <= n; ++i) {
						int idx1 = index[i]+j;
						if(idx1 >= m) idx1 -= m;
						if(arr[i][idx1] > 0 && !check[i][idx1]) {
							if(arr[i][idx1] > average) {
								arr[i][idx1]--;
							}else if(arr[i][idx1] < average) {
								arr[i][idx1]++;
							}
						}
					}
				}
			}
		}
		int sum = 0;
		for(int i = 1; i <= n; ++i) {
			for(int j = 0; j < m; ++j) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
}