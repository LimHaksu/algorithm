import java.io.*;
import java.util.*;
public class boj1197 {
	static class Node implements Comparable<Node>{
		int from, to, len;
		Node(int from, int to, int len){
			if(from < to) {
				this.from = from;
				this.to = to;
			}else {
				this.from = to;
				this.to = from;
			}
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.len, o.len);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < e; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a,b,c));
		}
		int ans = 0;
		int[] parrent = new int[v+1];
		for(int i = 1; i <= v; ++i) {
			parrent[i] = i;
		}
		int count = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			// 사이클 없으면 넣기
			int fromP = find(parrent, node.from);
			int toP = find(parrent, node.to);
			if(fromP != toP) {
				union(parrent, fromP, toP);
				ans += node.len;
				count++;
			}
			if(count == v-1) {
				break;
			}
		}
		System.out.println(ans);
	}
	static int find(int[] p, int n) {
		int np = p[n];
		if(np == n) {
			return n;
		}
		return p[n] = find(p, np);
	}
	static void union(int[] p, int a, int b) {
		int ap = find(p, a);
		int bp = find(p, b);
		if(ap < bp) {
			p[bp] = ap;
		}else if(ap > bp) {
			p[ap] = bp;
		}
	}
}
