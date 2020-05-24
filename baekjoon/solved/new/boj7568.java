package boj;

import java.io.*;
import java.util.*;
public class boj7568 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			int count = 1;
			for(int j = 0; j < n; ++j) {
				if(i != j) {
					if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
						count++;
					}
				}
			}
			sb.append(count).append(' ');
		}
		System.out.println(sb);
	}
}
