import java.io.*;
import java.util.*;
public class boj17472 {
	static class Bridge implements Comparable<Bridge>{
		int from;
		int to;
		int len;
		Bridge(int from, int to, int len){
			if(this.from < this.to) {
				this.from = from;
				this.to = to;
			}else {
				this.from = to;
				this.to = from;
			}
			this.len = len;
		}
		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(this.len, o.len);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
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
		int numOfArea = findArea(arr);
		PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j]>0) {
					int[] f = findLeft(arr,i,j);
					if(f[0]!=-1) {
						pq.add(new Bridge(f[0], f[1], f[2]));
					}
					f = findUp(arr,i,j);
					if(f[0]!=-1) {
						pq.add(new Bridge(f[0], f[1], f[2]));
					}
				}
			}
		}
		int answer = 0;
		int[] parrent = new int[numOfArea+1];
		for(int i = 1; i < parrent.length; ++i) {
			parrent[i] = i;
		}
		int count = 0;
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			if(union(parrent, b.from, b.to)) {
				answer += b.len;
				count++;
			};
			if(count == numOfArea-1) {
				break;
			}
		}
		System.out.println((answer == 0 || count != numOfArea-1)? -1 : answer);
	}
	static int findParrent(int[] p, int n) {
		int np = p[n];
		if(np == n) {
			return  np;
		}
		return p[n] = findParrent(p, np);
	}
	static boolean union(int[] p, int a, int b) {
		int ap = findParrent(p, a);
		int bp = findParrent(p, b);
		if(ap < bp) {
			p[bp] = ap;
			return true;
		}else if(ap > bp) {
			p[ap] = bp;
			return true;
		}
		return false;
	}
	static int[] findLeft(int[][] arr, int cr, int cc) {
		int nc = cc-1;
		int bridgeLen = 0;
		while(nc >= 0) {
			if(arr[cr][nc] == 0) {
				bridgeLen++;
				nc--;
			}else {
				break;
			}
		}
		if(nc >= 0 && arr[cr][nc] != 0 && arr[cr][nc] != arr[cr][cc] && bridgeLen > 1) {
			return new int[] {arr[cr][cc], arr[cr][nc], bridgeLen};
		}else {
			return new int[] {-1};
		}
	}
	
	// 위쪽으로 뻗어나가서 만나는 구역 있는지 찾기
	// 찾았으면 {현재숫자, 만나는 숫자, 다리길이} // 다리길이는 2이상
	// 못찾았으면 {-1};
	static int[] findUp(int[][] arr, int cr, int cc) {
		int nr = cr-1;
		int bridgeLen = 0;
		while(nr>=0) {
			if(arr[nr][cc] == 0) {
				bridgeLen++;
				nr--;
			}else {
				break;
			}
		}
		if(nr >= 0 && arr[nr][cc] != 0 && arr[nr][cc] != arr[cr][cc] && bridgeLen > 1) {
			return new int[] {arr[cr][cc], arr[nr][cc], bridgeLen};
		}else {
			return new int[] {-1};
		}
	}
	
	// 각 구역 나누기
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int findArea(int[][] arr) {
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int num = 1;
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				if(!visited[i][j] && arr[i][j] == 1) {
					dfs(arr,visited,num,i,j);
					num++;
				}
			}
		}
		return num-1;
	}
	static void dfs(int[][] arr, boolean[][] visited, int num, int cr, int cc) {
		visited[cr][cc] = true;
		arr[cr][cc] = num;
		for(int i = 0; i < 4; ++i) {
			int nr = cr + dr[i];
			int nc = cc + dc[i];
			if(bdCheck(arr,nr,nc) && !visited[nr][nc] && arr[nr][nc] == 1) {
				dfs(arr,visited,num,nr,nc);
			}
		}
	}
	static boolean bdCheck(int[][] arr, int cr, int cc) {
		return cr >= 0 && cr < arr.length && cc >= 0 && cc < arr[0].length;
	}
}
