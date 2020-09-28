import java.io.*;
import java.util.*;

public class boj1504 {
	static Map<Integer, Map<Integer, Integer>> fromToCost = new HashMap<Integer, Map<Integer, Integer>>();
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; ++i) {
			fromToCost.put(i, new HashMap<>());
		}
		for (int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			fromToCost.get(f).put(t, c);
			fromToCost.get(t).put(f, c);
		}
		st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int sToN1 = dijkstra(1, n1);
		int n2ToF = dijkstra(n2, n);

		int sToN2 = dijkstra(1, n2);
		int n1ToF = dijkstra(n1, n);

		int n1ToN2 = dijkstra(n1, n2);
		if (((sToN1 == -1 || n2ToF == -1) && (sToN2 == -1 || n1ToF == -1)) || n1ToN2 == -1) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(sToN1 + n2ToF, sToN2 + n1ToF) + n1ToN2);
		}
	}

	static int dijkstra(int from, int to) {
		int[] cost = new int[n+1];
		for(int i = 1; i <= n; ++i) {
			cost[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int[] current = { from, 0 };
		pq.add(current);
		while (!pq.isEmpty()) {
			current = pq.poll();
			int currentNumber = current[0];
			int currentCost = current[1];
			if (currentNumber == to) {
				return currentCost;
			}

			if (cost[currentNumber] < currentCost) {
				continue;
			}
			cost[currentNumber] = currentCost;
			
			for (int nextNumber : fromToCost.get(currentNumber).keySet()) {
				int nextCost = fromToCost.get(currentNumber).get(nextNumber) + currentCost;
				pq.add(new int[] { nextNumber, nextCost });
			}
		}
		return -1;
	}
}
