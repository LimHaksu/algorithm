package boj;

import java.util.*;
import java.io.*;
public class t2 {
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int g,r,n,m;
	static int[][] ground;
	static int[] dr = { -1, 0, 1, 0};
	static int[] dc = { 0, 1, 0, -1};
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		ground = new int[n][m];
		ArrayList<Node> possible = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(ground[i][j] == 2) {
					possible.add(new Node(i,j));
				}
			}
		}
		ArrayList<Node> arr = new ArrayList<>();
		boolean[][] visited = new boolean[n][m];
		dfs(possible, arr, visited, 0);
		System.out.println(answer);
	}
	static void selectG(ArrayList<Node> arr, ArrayList<Node> green, boolean[] selected, int idx) {
		if(green.size() == g) {
			ArrayList<Node> red = new ArrayList<>();
			for(int i = 0; i < selected.length; ++i) {
				if(!selected[i]) {
					red.add(arr.get(i));
				}
			}
			int[][] tempGround = new int[n][m];
			// 4 r, 5 g, 6 flower
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					tempGround[i][j] = ground[i][j];
				}
			}
			ArrayList<Node> currentR = new ArrayList<>();
			ArrayList<Node> currentG = new ArrayList<>();
			for(Node r : red) {
				tempGround[r.r][r.c] = 4;
				currentR.add(new Node(r.r,r.c));
			}
			for(Node g : green) {
				tempGround[g.r][g.c] = 5;
				currentG.add(new Node(g.r, g.c));
			}
			int count = 0;
			while(currentR.size() > 0 && currentG.size() > 0) {
				boolean[][] redCheck = new boolean[n][m];
				ArrayList<Node> nextR = new ArrayList<>();
				ArrayList<Node> nextG = new ArrayList<>();
				for(Node r : currentR) {
					for(int i = 0; i < 4; ++i) {
						int nr = r.r + dr[i];
						int nc = r.c + dc[i];
						if(bdCheck(tempGround, nr, nc) && (tempGround[nr][nc] == 2 || tempGround[nr][nc] == 1)) {
							nextR.add(new Node(nr,nc));
							tempGround[nr][nc] = 4;
							redCheck[nr][nc] = true;
						}
					}
				}
				for(Node g : currentG) {
					for(int i = 0; i < 4; ++i) {
						int nr = g.r + dr[i];
						int nc = g.c + dc[i];
						if(bdCheck(tempGround, nr, nc) && (tempGround[nr][nc] == 2 || tempGround[nr][nc] == 1 || tempGround[nr][nc] == 4)) {
							if(redCheck[nr][nc]) {
								tempGround[nr][nc] = 6;
								count++;
							}else {
								nextG.add(new Node(nr,nc));
								tempGround[nr][nc] = 5;
							}
						}
					}
				}
				currentR = new ArrayList<>();
				for(Node r : nextR) {
					if(tempGround[r.r][r.c] != 6) {
						currentR.add(r);
					}
				}
				currentG = nextG;
			}
			if(count > answer) {
				answer = count;
			}
			return;
		}
		if(idx == selected.length) {
			return;
		}
		if(!selected[idx]) {
			selected[idx] = true;
			green.add(arr.get(idx));
			selectG(arr,green,selected,idx+1);
			green.remove(green.size()-1);
			selected[idx] = false;
		}
		selectG(arr,green,selected,idx+1);
	}
	static void print(int[][] ground) {
		for(int i = 0; i < ground.length; ++i) {
			System.out.println(Arrays.toString(ground[i]));
		}
	}
	static boolean bdCheck(int[][] arr, int r, int c) {
		return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
	}
	static void dfs(ArrayList<Node> arr, ArrayList<Node> arr2, boolean[][] visited, int idx) {
		if(arr2.size() == g+r) {
			ArrayList<Node> green = new ArrayList<>();
			boolean[] selected = new boolean[arr2.size()];
			selectG(arr2, green, selected, 0);
			return;
		}
		if(idx == arr.size()) {
			return;
		}
		Node temp = arr.get(idx);
		if(ground[temp.r][temp.c] == 2) {
			if(!visited[temp.r][temp.c]) {
				visited[temp.r][temp.c] = true;
				arr2.add(temp);
				dfs(arr, arr2, visited, idx+1);
				arr2.remove(arr2.size()-1);
				visited[temp.r][temp.c]= false;
			}
		dfs(arr, arr2,visited,idx+1);
		}
	}
}
