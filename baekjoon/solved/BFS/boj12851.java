import java.io.*;
import java.util.*;

public class boj12851 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[100001][2];
		arr[n][1] = 1;
		boolean[] visited = new boolean[100001];
		visited[n] = true;
		bfs(arr, n, k, visited);
		System.out.println(arr[k][0] + "\n" + arr[k][1]);
	}

	static void bfs(int[][] arr, int x, int k, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int current = x;
		q.add(current);
		while (!q.isEmpty()) {
			current = q.poll();
			for (int next : new int[] { current - 1, current + 1, current * 2 }) {
				if (isValid(next)) {
					if (!visited[next]) {
						visited[next] = true;
						arr[next][0] = arr[current][0] + 1;
						q.add(next);
						arr[next][1] = arr[current][1];
					} else if (arr[next][0] == arr[current][0] + 1) {
						arr[next][1] += arr[current][1];
					}
				}
			}
		}
	}

	static boolean isValid(int n) {
		return n >= 0 && n <= 100000;
	}
}
