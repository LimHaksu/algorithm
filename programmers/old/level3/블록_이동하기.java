package One;

import java.util.*;

class Solution {
	int[][] board;
	boolean[][][] visited;
	int answer = -1;

	public int solution(int[][] b) {
		board = b;
		visited = new boolean[b.length][b[0].length][2];
		bfs(0, 0, 0);
		return answer;
	}

	void bfs(int r, int c, int state) {
		int[] current = { r, c, state };
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(current);
		while (!q.isEmpty()) {
			answer++;
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				current = q.poll();
				r = current[0];
				c = current[1];
				state = current[2];
				if (!visited[r][c][state]) {
					visited[r][c][state] = true;
					if (finishCheck(r, c, state)) {
						return;
					}
					for (int d = 0; d < 4; ++d) {
						// 움직일 수있는지
						if (moveCheck(r, c, state, d)) {
							q.add(move(r, c, state, d));
						}
						// 회전 가능한지
						if (turnCheck(r, c, state, d)) {
							q.add(turn(r, c, state, d));
						}
					}
				}
			}
		}
	}

	boolean finishCheck(int r, int c, int state) {
		switch (state) {
		case 0:
			if (r == board.length - 1 && c == board[0].length - 2)
				return true;
			break;
		case 1:
			if (r == board.length - 2 && c == board[0].length - 1)
				return true;
			break;
		}
		return false;
	}

	// d : 0 시계, 1 반시계
	int[] turn(int r, int c, int state, int d) {
		switch (state) {
		case 0:
			state = 1;
			if (d == 1) {
				r--;
			} else if (d == 2) {
				c++;
			} else if (d == 3) {
				r--;
				c++;
			}
			break;
		case 1:
			state = 0;
			if (d == 0) {
				c--;
			} else if (d == 2) {
				r++;
				c--;
			} else if (d == 3) {
				r++;
			}
			break;
		}
		return new int[] { r, c, state };
	}

	boolean turnCheck(int r, int c, int state, int d) {
		switch (state) {
		case 0:
			if (d == 0 || d == 2) {
				if (r >= board.length - 1)
					return false;
				if (board[r + 1][c] == 1 || board[r + 1][c + 1] == 1)
					return false;
			} else {
				if (r <= 0)
					return false;
				if (board[r - 1][c] == 1 || board[r - 1][c + 1] == 1)
					return false;
			}
			break;
		case 1:
			if (d == 0 || d == 2) {
				if (c <= 0)
					return false;
				if (board[r][c - 1] == 1 || board[r + 1][c - 1] == 1)
					return false;
			} else {
				if (c >= board[0].length - 1)
					return false;
				if (board[r][c + 1] == 1 || board[r + 1][c + 1] == 1)
					return false;
			}
			break;
		}
		return true;
	}

	// d : 0 위, 1 오, 2 아래, 3 왼
	boolean moveCheck(int r, int c, int state, int d) {
		switch (state) {
		case 0:
			switch (d) {
			case 0:
				if (r <= 0)
					return false;
				if (board[r - 1][c] == 1 || board[r - 1][c + 1] == 1)
					return false;
				break;
			case 1:
				if (c >= board[0].length - 2)
					return false;
				if (board[r][c + 2] == 1)
					return false;
				break;
			case 2:
				if (r >= board.length - 1)
					return false;
				if (board[r + 1][c] == 1 || board[r + 1][c + 1] == 1)
					return false;
				break;
			case 3:
				if (c <= 0)
					return false;
				if (board[r][c - 1] == 1)
					return false;
				break;
			}
			break;
		case 1:
			switch (d) {
			case 0:
				if (r <= 0)
					return false;
				if (board[r - 1][c] == 1)
					return false;
				break;
			case 1:
				if (c >= board[0].length - 1)
					return false;
				if (board[r][c + 1] == 1 || board[r + 1][c + 1] == 1)
					return false;
				break;
			case 2:
				if (r >= board.length - 2)
					return false;
				if (board[r + 2][c] == 1)
					return false;
				break;
			case 3:
				if (c <= 0)
					return false;
				if (board[r][c - 1] == 1 || board[r + 1][c - 1] == 1)
					return false;
				break;
			}
			break;
		}
		return true;
	}

	int[] move(int r, int c, int state, int d) {
		switch (d) {
		case 0:
			r--;
			break;
		case 1:
			c++;
			break;
		case 2:
			r++;
			break;
		case 3:
			c--;
			break;
		}
		return new int[] { r, c, state };
	}
}

public class 블록_이동하기 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		Solution sol = new Solution();
		System.out.println(sol.solution(board));
	}
}
