package boj;
import java.io.*;
import java.util.*;
public class boj3109 {
	static int answer = 0;
	static int r, c;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		for(int i = 0; i < r; ++i) {
			String line = br.readLine();
			for(int j = 0; j < c; ++j) {
				arr[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[r][c];
		for(int i = 0; i < r; ++i) {
			dfs(i,0);
		}
		System.out.println(answer);
	}
	static boolean dfs(int cr, int cc) {
		visited[cr][cc] = true;
		if(cc == c-2) {
			answer++;
			return true;
		}
		for(int i = 0; i < 3; ++i) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(bdCheck(nr,nc) && !visited[nr][nc] && arr[nr][nc]=='.') {
				if(dfs(nr,nc)) {
					return true;
				};
			}
		}
		return false;
	}
	static boolean bdCheck(int cr, int cc) {
		return cr >= 0 && cr < r && cc >= 0 && cc < c;
	}
}
