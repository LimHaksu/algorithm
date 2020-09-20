import java.io.*;
import java.util.*;

class Node2 implements Comparable<Node2> {
	int v;
	int e;

	Node2(int v, int e) {
		this.v = v;
		this.e = e;
	}

	@Override
	public int compareTo(Node2 o) {
		return Integer.compare(this.e, o.e);
	}
}

public class boj1753 {
	static final int INF = 3_100_000;
	static int v,e,k;
	static List<List<Node2>> list;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i <= v; ++i) {
			list.add(new ArrayList<>());
		}
		dist = new int[v+1];
		Arrays.fill(dist, INF);
		for(int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node2(e, w));
		}
		dijkstra(k);
		StringBuilder answer = new StringBuilder();
		for(int i = 1; i <= v; ++i) {
			if(dist[i] == INF) {
				answer.append("INF\n");
			}else {
				answer.append(dist[i]).append('\n');
			}
		}
		System.out.print(answer);
	}

	static void dijkstra(int k) {
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		boolean[] check = new boolean[v+1];
		pq.add(new Node2(k, 0));
		dist[k] = 0;
		while(!pq.isEmpty()) {
			Node2 current = pq.poll();
			int cv = current.v;
			if(check[cv]) {
				continue;
			}
			check[cv] = true;
			for(Node2 node: list.get(cv)) {
				if(dist[node.v] > dist[cv] + node.e ) {
					dist[node.v]= dist[cv] + node.e;
					pq.add(new Node2(node.v, dist[node.v]));
				}
			}
		}
	}
}
