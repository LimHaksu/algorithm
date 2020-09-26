import java.util.*;

class Solution {
	class Node implements Comparable<Node> {
		int idx;
		int num;
		boolean deleted = false;

		Node(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}

		public int compareTo(Node o) {
			return Integer.compare(this.num, o.num);
		}

		public String toString() {
			return "" + idx + "," + num + "," + deleted;
		}
	}

	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		ArrayList<Node> arr = new ArrayList<>();
		int arrIdx = 0;
		int num;
		PriorityQueue<Node> max = new PriorityQueue<Node>(Collections.reverseOrder());
		PriorityQueue<Node> min = new PriorityQueue<Node>();

		for (int i = 0; i < operations.length; ++i) {
			String[] op = operations[i].split(" ");
			if (op[0].equals("I")) {
				num = Integer.parseInt(op[1]);
				Node node = new Node(arrIdx++, num);
				max.add(node);
				min.add(node);
				arr.add(node);
			} else {
				if (Integer.parseInt(op[1]) == 1) {
					if (!max.isEmpty()) {
						int idx = max.poll().idx;
						while (!max.isEmpty() && arr.get(idx).deleted) {
							idx = max.poll().idx;
						}
						arr.get(idx).deleted = true;
					}
				} else {
					if (!min.isEmpty()) {
						int idx = min.poll().idx;
						while (!min.isEmpty() && arr.get(idx).deleted) {
							idx = min.poll().idx;
						}
						arr.get(idx).deleted = true;
					}
				}
			}
		}
		answer[0] = Integer.MIN_VALUE;
		answer[1] = Integer.MAX_VALUE;
		for (int i = 0; i < arr.size(); ++i) {
			if (!arr.get(i).deleted) {
				if (answer[0] < arr.get(i).num)
					answer[0] = arr.get(i).num;
				if (answer[1] > arr.get(i).num)
					answer[1] = arr.get(i).num;
			}
		}
		if (answer[0] == Integer.MIN_VALUE) {
			answer[1] = answer[0] = 0;
		}
		return answer;
	}
}

public class 이중우선순위큐 {
	public static void main(String[] args) {
//		String[] operations = {"I 16","D 1"};
		String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(operations)));
	}
}
