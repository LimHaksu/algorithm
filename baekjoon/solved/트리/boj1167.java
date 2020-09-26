import java.io.*;
import java.util.*;

class Node{
	int number, value;
	Map<Integer, Integer> map = new HashMap<>();
	Node(int n){
		this.number = n;
	}
}
public class boj1167{
	static int ans = 0;
	static Node[] nodes;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		nodes = new Node[v+1];
		for(int i = 1; i <= v; ++i) {
			nodes[i] = new Node(i);
		}
		visited = new boolean[v+1];
		for(int i = 1; i <= v; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int num2 = Integer.parseInt(st.nextToken());
				if(num2 != -1) {
					int cost = Integer.parseInt(st.nextToken());
					nodes[num].map.put(num2, cost);
					nodes[num2].map.put(num, cost);
				}
			}
		}
		dfs(0, 1);
		System.out.println(ans);
	}
	static void dfs(int parent, int current) {
		if(visited[current]) {
			return;
		}
		visited[current] = true;
		if(nodes[current].map.size() == 0) {
			nodes[current].value = 0;
			return;
		}
		for(int child : nodes[current].map.keySet()) {
			dfs(current, child);
		}
		int max = 0;
		int maxNode = 0;
		for(int child: nodes[current].map.keySet()) {
			if(child != parent && nodes[child].value + nodes[current].map.get(child) > max) {
				max = nodes[child].value + nodes[current].map.get(child);
				maxNode = child;
			}
		}
		nodes[current].map.remove(maxNode);
		int max2 = 0;
		if(nodes[current].map.size()>0) {
			for(int child : nodes[current].map.keySet()) {
				if(child != parent && nodes[child].value + nodes[current].map.get(child) > max2) {
					max2 = nodes[child].value + nodes[current].map.get(child);
				}
			}
		}
		if(max + max2 > ans) {
			ans = max + max2;
		}
		nodes[current].value = max;
	}
}