import java.util.*;

class Solution {
	class Node implements Comparable<Node> {
		int from;
		int to;
		int edge;

		Node(int from, int to, int edge) {
			this.from = from;
			this.to = to;
			this.edge = edge;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.edge, o.edge);
		}
	}

	public int solution(int n, int[][] costs) {
		int answer = 0;
		// 선택된 노드 셋, edge 정보는 pq, pq에서 하나 뽑은후 선택된 노드셋에 없으면 추가, 선택된 노드셋이 n과 같아질때까지
		HashSet<Integer> set = new HashSet<Integer>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
		for (int i = 0; i < n; ++i) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < costs.length; ++i) {
			int n1 = costs[i][0];
			int n2 = costs[i][1];
			int edge = costs[i][2];
			map.get(n1).add(new Node(n1, n2, edge));
			map.get(n2).add(new Node(n2, n1, edge));
		}
		int current = 0;
		set.add(current);
		for (Node node : map.get(current)) {
			pq.add(node);
		}
		while (set.size() < n) {
			while (true) {
				Node node = pq.remove();
				if (!set.contains(node.to)) {
					set.add(node.to);
					answer += node.edge;
					for(Node temp : map.get(node.to)) {
						pq.add(temp);
					}
					break;
				}
			}
		}
		return answer;
	}
}

public class 섬_연결하기 {
	public static void main(String[] args) {
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(n, costs));
	}
}
