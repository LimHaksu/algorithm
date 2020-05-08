package D;

import java.io.*;
import java.util.*;
public class D{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int[][] arr = new int[9][9];
			for(int i = 0; i < 9; ++i) {
				String line = br.readLine();
				for(int j = 0; j < 9; ++j) {
					arr[i][j] = line.charAt(j)-'0';
				}
			}
			arr[0][0] = arr[0][0]%9+1;
			arr[1][3] = arr[1][3]%9+1;
			arr[2][6] = arr[2][6]%9+1;
			arr[3][1] = arr[3][1]%9+1;
			arr[4][4] = arr[4][4]%9+1;
			arr[5][7] = arr[5][7]%9+1;
			arr[6][2] = arr[6][2]%9+1;
			arr[7][5] = arr[7][5]%9+1;
			arr[8][8] = arr[8][8]%9+1;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; ++i) {
				for(int j = 0; j < 9; ++j) {
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
			ans.append(sb);
		}
		System.out.println(ans);
	}
}