package C;

import java.io.*;
import java.util.*;
public class C {
	static Map<Integer, HashSet<Integer>> map;
	static boolean[] visited;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map = new HashMap<Integer, HashSet<Integer>>(); 
			for(int i = 1; i <= n; ++i) {
				map.put(i, new HashSet<Integer>());
			}
			visited = new boolean[n+1];
			for(int i = 0; i < n-1; ++i) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map.get(u).add(v);
				map.get(v).add(u);
			}
			count = 0;
			if(map.get(x).size()<=1) {
				ans.append("Ayush\n");
				continue;
			}
			visited[x] = true;
			dfs(x, 1);
			if(count%2==1) {
				ans.append("Ayush\n");
			}else {
				ans.append("Ashish\n");
			}
		}
		System.out.print(ans);
	}
	static void dfs(int currentNum, int depth) {
		for(int c : map.get(currentNum)) {
			if(!visited[c]) {
				visited[c] = true;
				if(depth >= 1) {
					count++;
				}
				dfs(c, depth+1);
			}
		}
	}
}
