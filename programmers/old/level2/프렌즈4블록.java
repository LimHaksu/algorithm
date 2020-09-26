import java.util.*;

class Solution {
	void print(char[][] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] arr = new char[m][n];
		for (int i = 0; i < m; ++i) {
			arr[i] = board[i].toCharArray();
		}
		while (true) {
			boolean[][] check = new boolean[m][n];
			int count = 0;
			for (int i = 0; i < m - 1; ++i) {
				for (int j = 0; j < n - 1; ++j) {
					if (arr[i][j] != ' ' && arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i + 1][j]
							&& arr[i + 1][j] == arr[i + 1][j + 1]) {
						check[i][j] = check[i][j + 1] = check[i + 1][j] = check[i + 1][j + 1] = true;
						count++;
					}
				}
			}
			if (count == 0) {
				break;
			}
			for (int j = 0; j < n; ++j) {
				Queue<Character> q = new LinkedList<>();
				for (int i = m - 1; i >= 0; --i) {
					if (!check[i][j]) {
						q.add(arr[i][j]);
					}
				}
				int idx = m - 1;
				while (!q.isEmpty()) {
					arr[idx--][j] = q.poll();
				}
				while (idx >= 0) {
					arr[idx--][j] = ' ';
				}
			}
		}
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(arr[i][j] == ' ') {
					answer++;
				}
			}
		}
		return answer;
	}
}

public class 프렌즈4블록 {
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		Solution sol = new Solution();
		System.out.println(sol.solution(m, n, board));
	}
}
