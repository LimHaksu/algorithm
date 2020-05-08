package boj;
import java.io.*;
import java.util.*;
public class boj17072 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][3*m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3*m; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				int intensity = arr[i][3*j]*2126 + arr[i][3*j+1]*7152 + arr[i][3*j+2]*722; 
				if(intensity >= 0 && intensity < 510000) {
					sb.append('#');
				}else if(intensity >= 510000 && intensity <1020000) {
					sb.append('o');
				}else if(intensity >= 1020000 && intensity < 1530000) {
					sb.append('+');
				}else if(intensity >= 1530000 && intensity < 2040000) {
					sb.append('-');
				}else if(intensity >= 2040000) {
					sb.append('.');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
