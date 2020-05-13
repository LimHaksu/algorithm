import java.io.*;
import java.util.*;
public class boj17073 {
	static HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
	static int n;
	static int leafCount = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; ++i) {
			map.put(i, new HashSet<Integer>());
		}
		for(int i = 0; i < n-1; ++i) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map.get(n1).add(n2);
			map.get(n2).add(n1);
		}
		boolean[] visited = new boolean[n+1];
		visited[1] = true;
		dfs(1, visited);
		double answer = (double)w / leafCount;
		System.out.println(answer);
	}
	static void dfs(int cn, boolean[] visited) {
		int count = 0;
		for(int nn : map.get(cn)) {
			if(!visited[nn]) {
				visited[nn] = true;
				count++;
				dfs(nn, visited);
			}
		}
		if(count == 0) {
			leafCount++;
		}
	}
}
