import java.util.*;
import java.io.*;

public class boj10026 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		for(int i = 0; i < n; ++i) {
			arr[i] = br.readLine().toCharArray();
		}
		int countForNonRedGreen = 0;
		boolean[][] visited = new boolean[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(!visited[i][j]) {
					countForNonRedGreen++;
				}
				countF(arr, visited, i, j);
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		int countForRedGreen = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(!visited[i][j]) {
					countForRedGreen++;
				}
				countF(arr, visited, i, j);
			}
		}
		System.out.println(countForNonRedGreen + " "+ countForRedGreen);
	}
	static void countF(char[][] arr, boolean[][] visited, int cr, int cc) {
		for(int i = 0; i < 4; ++i) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(bdCheck(nr, nc, arr) && !visited[nr][nc]) {
				if(arr[nr][nc] == arr[cr][cc]) {
					visited[nr][nc] = true;
					countF(arr, visited, nr, nc);
				}
			}
		}
	}
	
	static boolean bdCheck(int r, int c, char[][] arr) {
		return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
	}
}
