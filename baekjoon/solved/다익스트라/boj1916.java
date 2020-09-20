import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int to;
	long weight;
	Node(int to, long weight){
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return Long.compare(this.weight, o.weight);
	}
}
public class boj1916 {
	static List<List<Node>> arr = new ArrayList<List<Node>>();
	static int n, m;
	static final long INF = 10_000_000_001L;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for(int i = 0 ; i <= n; ++i) {
			arr.add(new ArrayList<>());
		}
		for(int i = 0; i < m; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			arr.get(from).add(new Node(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		long answer = dijkstra(from, to);
		System.out.println(answer);
	}
	
	static long dijkstra(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		long[] dist = new long[n+1];
		for(int i = 1; i <= n; ++i) {
			dist[i] = INF;
		}
		boolean[] check = new boolean[n+1];
		pq.add(new Node(from, 0));
		dist[from] = 0;
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(check[current.to]) {
				continue;
			}
			check[current.to] = true;
			for(Node node : arr.get(current.to)) {
				if( dist[node.to] > dist[current.to] + node.weight) {
					dist[node.to] = dist[current.to] + node.weight;
					pq.add(new Node(node.to, dist[node.to]));
				}
			}
		}
		return dist[to];
	}
}
