import java.io.*;
import java.util.*;

public class boj15684 {
	static int[][] arr;
	static int n, m, h;
	static int answer = Integer.MAX_VALUE;
	static int[] arrR = new int[3];
	static int[] arrC = new int[3];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h + 1][n + 1];
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		solve();
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
	static int getLadder(int c) {
		int r = 1;
		while (r <= h) {
			if (arr[r][c] == 1) {
				c++;
			} else if (arr[r][c - 1] == 1) {
				c--;
			}
			r++;
		}
		return c;
	}

	static void solve() {
		// 0개인 경우
		boolean check = true;
		for (int i = 1; i <= n; ++i) {
			int nc = getLadder(i);
			if (nc != i) {
				check = false;
				break;
			}
		}
		if(check) {
			answer = 0;
			return;
		}
		// count개 만큼 선택
		for (int cnt = 1; cnt <= 3; ++cnt) {
			boolean[] checked = new boolean[n * h + 1];
			dfs(cnt, 1, checked, 0);
			if (answer < Integer.MAX_VALUE) {
				break;
			}
		}
	}
	static boolean nearCheck(int r, int c) {
		if(arr[r][c] == 1 || arr[r][c-1] ==1 || arr[r][c+1]==1) {
			return true;
		}
		return false;
	}
	static void dfs(int count, int idx, boolean[] checked, int currentCount) {
		if (currentCount == count) {
			// todo...
			int arrIdx = 0;
			for (int i = 0; i < checked.length; ++i) {
				if (checked[i]) {
					int r = i / n + 1;
					int c = i % n;
					if (c == 0) {
						c = n;
						r--;
					}
					if(c==n || nearCheck(r,c)) {
						for(int j = 0; j < arrIdx; ++j) {
							arr[arrR[j]][arrC[j]] = 0;
						}
						return;
					}
					arr[r][c] = 1;
					arrR[arrIdx] = r;
					arrC[arrIdx++] = c;
				}
			}
			boolean check = true;
			for (int i = 1; i <= n; ++i) {
				int nc = getLadder(i);
				if (nc != i) {
					check = false;
					break;
				}
			}
			for (int j = 0; j < arrIdx; ++j) {
				arr[arrR[j]][arrC[j]] = 0;
			}
			if (check) {
				if (count < answer) {
					answer = count;
				}
			}
			return;
		}
		if (idx >= checked.length) {
			return;
		}
		checked[idx] = true;
		dfs(count, idx + 1, checked, currentCount + 1);
		checked[idx] = false;
		dfs(count, idx + 1, checked, currentCount);
	}
}
