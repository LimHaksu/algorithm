import java.io.*;
import java.util.*;

public class boj1238 {
	static List<Map<Integer, Integer>> fromToCost = new ArrayList<Map<Integer,Integer>>();
    static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= n; ++i) {
			fromToCost.add(new HashMap<>());
		}
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			fromToCost.get(from).put(to, cost);
		}
		int[] xToN = dijkstra(x);
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			// i->x
			int cost = dijkstra(i)[x];
			// x->i
			cost += xToN[i];
			if(cost > ans) {
				ans = cost;
			}
		}
		System.out.println(ans);
	}
	static int[] dijkstra(int start) {
		int[] cost = new int[n+1];
		for(int i = 1; i <= n; ++i) {
			cost[i] = Integer.MAX_VALUE;
		}
		cost[start] = 0;
		int[] current = new int[] {start, 0};
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1],  o2[1]);
			}
		});
		pq.add(current);
		
		while(!pq.isEmpty()) {
			current = pq.poll();
			int cn = current[0];
			int cc = current[1];
			for(int nn : fromToCost.get(cn).keySet()) {
				int nc = fromToCost.get(cn).get(nn) + cc;
				if(nc < cost[nn]) {
					cost[nn] = nc;
					pq.add(new int[] {nn, nc});					
				}
			}
		}
		return cost;
	}
}
