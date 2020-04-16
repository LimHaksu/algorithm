package C;

import java.io.*;
import java.util.*;

public class C {
	static class Node {
		int num;
		ArrayList<Integer> children = new ArrayList<Integer>();
		int level;
		boolean ind = false;
		int count = 0;
		int descendantCount = 0;
		Node(int num) {
			this.num = num;
		}
		public String toString() {
			return ""+ind;
		}
	}

	static HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; ++i) {
			map.put(i, new Node(i));
		}
		for (int i = 0; i < n - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.get(u).children.add(v);
			map.get(v).children.add(u);
		}
		dfs(0, 1, 1);
		
		ArrayList<Node> arr = new ArrayList<>();
		for (Node node : map.values()) {
			arr.add(node);
		}
		dfsCount(0,1);
		Collections.sort(arr, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o2.level-o2.descendantCount,
						o1.level-o1.descendantCount);
			}
		});
		
		long answer = 0;
		for (int i = 0; i < k; ++i) {
			arr.get(i).ind = true;
		}
		dfs2(0,1,0);
		for(int i = 0; i < arr.size(); ++i) {
			if(arr.get(i).ind) {
				answer += (long)arr.get(i).count;
			}
		}
		System.out.println(answer);
	}
	static int dfsCount(int from, int current) {
		int count = 0;
		for(int c : map.get(current).children) {
			if(c != from) {
				count += dfsCount(current, c);
			}
		}
		count += map.get(current).children.size()-1;
		if(current==1) {
			count++;
		}
		map.get(current).descendantCount = count;
		return count;
	}
	static void dfs(int from, int current, int level) {
		for (int c : map.get(current).children) {
			if(c!=from) {
				map.get(c).level = level;
				dfs(current, c, level + 1);
			}
		}
	}
	static void dfs2(int from, int current, int level) {
		if(!map.get(current).ind) {
			level++;
		}
		map.get(current).count = level;
		for (int c : map.get(current).children) {
			if(c!=from) {
				dfs2(current, c, level);
			}
		}
	}
}
