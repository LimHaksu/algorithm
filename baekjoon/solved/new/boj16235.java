import java.io.*;
import java.util.*;

public class boj16235 {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, - 1 };

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][n + 1];
		int[][] ground = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				ground[i][j] = 5;
			}
		}
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, z));
		}
		for (int year = 0; year < k; ++year) {
			// 봄
			PriorityQueue<Tree> next = new PriorityQueue<>();
			ArrayList<Tree> dead = new ArrayList<>();
			while(!pq.isEmpty()) {
				Tree t = pq.remove();
				if (t.age <= ground[t.x][t.y]) {
					ground[t.x][t.y] -= t.age;
					t.age++;
					next.add(t);
				} else {
					dead.add(t);
				}
			}

			// 여름
			for (Tree t : dead) {
				ground[t.x][t.y] += t.age / 2;
			}
			// 가을
			for(Tree t : next) {
				if(t.age % 5 == 0) {
					for(int ii = 0; ii < 8;++ii) {
						int nr = t.x + dr[ii];
						int nc = t.y + dc[ii];
						if(bdCheck(nr, nc, n)){
							pq.add(new Tree(nr,nc,1));
						}
					}
				}
				pq.add(new Tree(t.x, t.y, t.age));
			}
			
			// 겨울
			for(int i = 1; i <= n; ++i) {
				for(int j = 1; j <= n; ++j) {
					ground[i][j] += arr[i][j];
				}
			}
		}
		System.out.println(pq.size());
	}

	static boolean bdCheck(int r, int c, int n) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}
}
