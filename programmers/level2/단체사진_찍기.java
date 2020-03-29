import java.util.*;

class Solution {
	class Node {
		char c1, c2, op;
		int dist;

		Node(char c1, char c2, int dist, char op) {
			this.c1 = c1;
			this.c2 = c2;
			this.dist = dist;
			this.op = op;
		}

		public String toString() {
			return "" + this.c1 + ", " + this.c2 + ", " + this.op + ", " + this.dist;
		}
	}

	boolean[] selected = new boolean[8];
	ArrayList<Node> condition = new ArrayList<>();
	char[] name = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	int answer = 0;

	public int solution(int n, String[] data) {
		for (int i = 0; i < data.length; ++i) {
			condition.add(new Node(data[i].charAt(0), data[i].charAt(2), data[i].charAt(4) - '0', data[i].charAt(3)));
		}
		Stack<Character> stack = new Stack<Character>();
		dfs(stack, selected);
		return answer;
	}

	void dfs(Stack<Character> stack, boolean[] selected) {
		if (stack.size() == 8) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			int idx = 0;
			for (char c : stack) {
				map.put(c, idx);
				idx++;
			}
			boolean check = true;
			f: for (Node cond : condition) {
				int idx1 = map.get(cond.c1);
				int idx2 = map.get(cond.c2);
				int dist = idx1 > idx2 ? idx1 - idx2 - 1 : idx2 - idx1 - 1;
				switch (cond.op) {
				case '=':
					if (dist != cond.dist) {
						check = false;
						break f;
					}
					break;
				case '>':
					if (dist <= cond.dist) {
						check = false;
						break f;
					}
					break;
				case '<':
					if (dist >= cond.dist) {
						check = false;
						break f;
					}
					break;
				}
			}
			if (check) {
				answer++;
			}
			return;
		}
		for (int i = 0; i < 8; ++i) {
			if (!selected[i]) {
				selected[i] = true;
				stack.push(name[i]);
				dfs(stack, selected);
				stack.pop();
				selected[i] = false;
			}
		}
	}
}

public class 단체사진_찍기 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(sol.solution(n, data));
	}
}
