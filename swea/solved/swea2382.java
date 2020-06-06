package swea;

import java.io.*;
import java.util.*;

public class swea2382 {
	static class Node {
		int amount;
		int direction;
		int r, c;

		Node(int a, int d, int r, int c) {
			this.amount = a;
			this.direction = d;
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static ArrayList<Node> nodes;
	static int n;
	static ArrayList<Node>[][] cell;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			nodes = new ArrayList<>();
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; ++i) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int amount = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				nodes.add(new Node(amount, d, r, c));
			}
			for (int i = 0; i < m; ++i) {
				move();
			}
			answer.append("#" + tc + " ").append(getTotal()).append('\n');
		}
		System.out.println(answer);
	}

	static boolean checkOnBoundary(int r, int c) {
		return r == 0 || r == n - 1 || c == 0 || c == n - 1;
	}

	static int getTotal() {
		int total = 0;
		for (Node node : nodes) {
			total += node.amount;
		}
		return total;
	}

	static void move() {
		ArrayList<Node> newNodes = new ArrayList<>();
		cell = new ArrayList[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				cell[i][j] = new ArrayList<>();
			}
		}
		for (Node node : nodes) {
			int nr = node.r + dr[node.direction];
			int nc = node.c + dc[node.direction];
			if (checkOnBoundary(nr, nc)) {
				if (node.direction <= 2) {
					node.direction = 3 - node.direction;
				} else {
					node.direction = 7 - node.direction;
				}
				node.amount /= 2;
			}
			node.r = nr;
			node.c = nc;
			cell[nr][nc].add(node);
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (cell[i][j].size() > 0) {
					int max = 0;
					int maxIdx = 0;
					int sum = 0;
					for (int k = 0; k < cell[i][j].size(); ++k) {
						if (cell[i][j].get(k).amount > max) {
							max = cell[i][j].get(k).amount;
							maxIdx = k;
						}
						sum += cell[i][j].get(k).amount;
					}
					int d = cell[i][j].get(maxIdx).direction;
					Node sumNode = new Node(sum, d, i, j);
					newNodes.add(sumNode);
				}
			}
		}
		nodes = newNodes;
	}
}
