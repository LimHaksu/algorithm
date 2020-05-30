import java.io.*;
import java.util.*;
public class boj2563 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		for(int t = 0; t < n; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int i = 0; i < 10; ++i) {
				for(int j = 0; j < 10; ++j) {
					arr[a+i][b+j] = 1;
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < 100; ++i) {
			for(int j = 0; j < 100; ++j) {
				if(arr[i][j]==1) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
