import java.util.*;

class Solution {
	int[] p;

	public int solution(int n, int[][] computers) {
		p = new int[n];
		for (int i = 0; i < n; ++i) {
			p[i] = i;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (computers[i][j] == 1) {
					union(i, j);
				}
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; ++i) {
			set.add(find(i));
		}
		return set.size();
	}

	void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa < pb) {
			p[pb] = pa;
		} else if (pb < pa) {
			p[pa] = pb;
		}
	}

	int find(int n) {
		int prnt = p[n];
		if (prnt != n) {
			return p[n] = find(prnt);
		}
		return prnt;
	}
}

public class 네트워크 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(n, computers));
	}
}
