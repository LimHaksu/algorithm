package C;

import java.io.*;
import java.util.*;
public class n1366C {
	static int[] dr1 = {0,1};
	static int[] dc1 = {1,0};
	static int[] dr2 = {0,-1};
	static int[] dc2 = {-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; ++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int totalCount = 0;
			ArrayList<ArrayList<Integer>> arrTop = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> arrBottom = new ArrayList<ArrayList<Integer>>();
			int[] crc1 = {0,0};
			int[] crc2 = {n-1,m-1};
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(crc1);
			arrTop.add(new ArrayList<>());
			arrTop.get(0).add(arr[crc1[0]][crc1[1]]);
			boolean[][] visited = new boolean[n][m];
			while(!q.isEmpty()) {
				int size = q.size();
				arrTop.add(new ArrayList<>());
				for(int i = 0; i < size; ++i) {
					crc1 = q.poll();
					for(int j = 0; j < 2; ++j) {
						int nr = crc1[0] + dr1[j];
						int nc = crc1[1] + dc1[j];
						if(bdCheck(nr,nc,n,m) && !visited[nr][nc]) {
							visited[nr][nc] = true;
							arrTop.get(arrTop.size()-1).add(arr[nr][nc]);
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			q = new LinkedList<int[]>();
			q.add(crc2);
			arrBottom.add(new ArrayList<>());
			arrBottom.get(0).add(arr[crc2[0]][crc2[1]]);
			visited = new boolean[n][m];
			while(!q.isEmpty()) {
				int size = q.size();
				arrBottom.add(new ArrayList<>());
				for(int i = 0; i < size; ++i) {
					crc2 = q.poll();
					for(int j = 0; j < 2; ++j) {
						int nr = crc2[0] + dr2[j];
						int nc = crc2[1] + dc2[j];
						if(bdCheck(nr,nc,n,m) && !visited[nr][nc]) {
							visited[nr][nc] = true;
							arrBottom.get(arrBottom.size()-1).add(arr[nr][nc]);
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
			int size = (arrTop.size()-1)/2;
			for(int i = 0; i < size; ++i) {
				int topOneCount = 0;
				int topZeroCount = 0;
				int bottomOneCount = 0;
				int bottomZeroCount = 0;
				for(int j = 0; j < arrTop.get(i).size(); ++j) {
					if(arrTop.get(i).get(j) == 0) {
						topZeroCount++;
					}else {
						topOneCount++;
					}
					if(arrBottom.get(i).get(j) == 0) {
						bottomZeroCount++;
					}else {
						bottomOneCount++;
					}
				}
				int min = Math.min(topOneCount+bottomOneCount, topZeroCount+bottomZeroCount);
				totalCount += min;
			}
			ans.append(totalCount).append('\n');
		}
		System.out.println(ans);
	}
	static boolean bdCheck(int r, int c, int n, int m) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}
}
