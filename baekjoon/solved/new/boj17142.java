import java.io.*;
import java.util.*;
public class boj17142 {
	static int answer = Integer.MAX_VALUE;
	static int emptyCount = 0;
	static ArrayList<int[]> virus = new ArrayList<>();
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					virus.add(new int[] {i,j});
				}else if(arr[i][j] == 0) {
					emptyCount++;
				}
			}
		}
		boolean[] checked = new boolean[virus.size()];
		dfs(m, checked, 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	static int[][] getNewArr(){
		int[][] result = new int[arr.length][arr.length];
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr.length; ++j) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean bdCheck(int r, int c) {
		return r >= 0 && r < arr.length && c >= 0 && c < arr.length;
	}
	static void dfs(int m, boolean[] checked, int idx, int count) {
		if(count == m) {
			// todo..
			int[][] temp = getNewArr();
			int tempEmptyCount = emptyCount;
			if(tempEmptyCount == 0) {
				answer = 0;
				return;
			}
			Queue<int[]> q = new LinkedList<int[]>();
			for(int i = 0; i < checked.length; ++i) {
				if(checked[i]) {
					int r = virus.get(i)[0];
					int c = virus.get(i)[1];
					temp[r][c] = 1;
					q.add(new int[] {r,c});
				}
			}
			int[][] tempOrigin = new int[temp.length][];
			for(int i = 0; i < temp.length; ++i) {
				tempOrigin[i] = temp[i].clone();
			}
			int time = 0;
			w: while(!q.isEmpty()) {
				time++;
				if(time > answer) {
					return;
				}
				int size = q.size();
				for(int i = 0; i < size; ++i) {
					int[] rc = q.poll();
					int cr = rc[0];
					int cc = rc[1];
					for(int j = 0; j < 4; ++j) {
						int nr = cr + dr[j];
						int nc = cc + dc[j];
						if(bdCheck(nr,nc) && temp[nr][nc] != 1) {
							if(temp[nr][nc] == 0) {
								tempEmptyCount--;
								if(tempEmptyCount == 0) {
									break w;
								}
							}
							temp[nr][nc] = 1;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			if(tempEmptyCount == 0 && time < answer) {
				answer = time;
			}
			return;
		}
		if(idx == checked.length) {
			return;
		}
		checked[idx] = true;
		dfs(m,checked, idx+1, count+1);
		checked[idx] = false;
		dfs(m, checked, idx+1, count);
	}
}
