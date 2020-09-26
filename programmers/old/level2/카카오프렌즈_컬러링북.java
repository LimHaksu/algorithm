package programmers;

import java.util.*;

public class 카카오프렌즈_컬러링북 {
	static class Solution {
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		public int[] solution(int m, int n, int[][] picture) {
			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (!visited[i][j] && picture[i][j] != 0) {
						visited[i][j] = true;
						numberOfArea++;
						int sizeOfArea = dfs(picture, visited, i, j, 1, picture[i][j]);
						if (sizeOfArea > maxSizeOfOneArea) {
							maxSizeOfOneArea = sizeOfArea;
						}
					}
				}
			}
			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;
			return answer;
		}

		public int dfs(int[][] picture, boolean[][] visited, int currentR, int currentC, int count, int currentColor) {
			for (int i = 0; i < 4; ++i) {
				int r = currentR + dr[i];
				int c = currentC + dc[i];
				if (bdCheck(picture, r, c) && currentColor == picture[r][c] && !visited[r][c]) {
					visited[r][c] = true;
					count = dfs(picture, visited, r, c, count + 1, currentColor);
				}
			}
			return count;
		}

		boolean bdCheck(int[][] picture, int currentR, int currentC) {
			return currentR >= 0 && currentR < picture.length && currentC >= 0 && currentC < picture[0].length;
		}
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(m, n, picture)));
	}
}
