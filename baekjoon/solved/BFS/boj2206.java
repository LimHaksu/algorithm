import java.util.*;
import java.io.*;

public class boj2206 {
	static int n, m;
	static int[][] map;
	static int[][][] arr;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		arr = new int[n][m][2]; // 세번째 : 남은 벽 부수기 횟수
		for (int i = 0; i < n; ++i) {
			String line = br.readLine();
			for (int j = 0; j < m; ++j) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static boolean bdCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[] current = { 0, 0, 1 };
		arr[0][0][1] = 1;
		q.add(current);
		w: while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; ++i) {
				current = q.poll();
				int cr = current[0];
				int cc = current[1];
				int remain = current[2];
				if (cr == n - 1 && cc == m - 1) {
					answer = arr[cr][cc][remain];
					break w;
				}
				for (int j = 0; j < 4; ++j) {
					int nr = cr + dr[j];
					int nc = cc + dc[j];
					if (bdCheck(nr, nc)) {
						if (map[nr][nc] == 0 && arr[nr][nc][remain] == 0) {
							arr[nr][nc][remain] = arr[cr][cc][remain]+1;
							q.add(new int[] { nr, nc, remain });
						} else if (map[nr][nc] == 1 && remain == 1) {
							arr[nr][nc][0] = arr[cr][cc][1] + 1;
							q.add(new int[] { nr, nc, 0 });
						}
					}
				}
			}
		}
	}
}
