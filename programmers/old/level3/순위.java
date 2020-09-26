import java.util.*;

class Solution {
	class Node {
		int num;
		ArrayList<Node> parrent = new ArrayList<>();
		ArrayList<Node> child = new ArrayList<>();

		Node(int n) {
			this.num = n;
		}
	}

	public int solution(int n, int[][] results) {
		int answer = 0;
		Node[] nodes = new Node[n + 1];
		for (int i = 1; i <= n; ++i) {
			nodes[i] = new Node(i);
		}
		for (int i = 0; i < results.length; ++i) {
			Node p = nodes[results[i][0]];
			Node c = nodes[results[i][1]];
			p.child.add(c);
			c.parrent.add(p);
		}
		for (int i = 1; i <= n; ++i) {
			boolean[] visited = new boolean[n + 1];
			int cC = countChild(nodes[i], visited) - 1;
			visited = new boolean[n + 1];
			int cP = countParrent(nodes[i], visited) - 1;
			if (cC + cP == n - 1) {
				answer++;
			}
		}
		return answer;
	}

	int countChild(Node current, boolean[] visited) {
		int sum = 1;
		for (Node child : current.child) {
			if (!visited[child.num]) {
				visited[child.num] = true;
				sum += countChild(child, visited);
			}
		}
		return sum;
	}

	int countParrent(Node current, boolean[] visited) {
		int sum = 1;
		for (Node parrent : current.parrent) {
			if (!visited[parrent.num]) {
				visited[parrent.num] = true;
				sum += countParrent(parrent, visited);
			}
		}
		return sum;
	}
}

public class 순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(n, results));
	}
}
