import java.io.*;
import java.util.*;

public class boj2638 {
	static int n, m;
	static int[][] count;
	static boolean[][] cheese;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int remain = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cheese = new boolean[n][m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					cheese[i][j] = true;
					remain++;
				}
			}
		}
		int ans = 0;
		while(remain > 0) {
			ans++;
			step();
		}
		System.out.println(ans);
	}
	
	static void step() {
		count = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		int[] current = new int[] {0,0};
		q.add(current);
		while(!q.isEmpty()) {
			current = q.poll();
			int cr = current[0];
			int cc = current[1];
			for(int i = 0; i < 4; ++i) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				if(bdCheck(nr, nc)) {
					if(cheese[nr][nc]) {
						count[nr][nc]++;
					}else if(!visited[nr][nc]){
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(count[i][j] >= 2) {
					cheese[i][j] = false;
					remain--;
				}
			}
		}
	}
	
	static boolean bdCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
}
