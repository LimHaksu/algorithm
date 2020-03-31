package Two;

class Solution2 {
	int MOD = 20170805;

	public int solution(int m, int n, int[][] cityMap) {
		// 0 : 통행가능, 1 : 통행금지, 2: 직진만 가능
		int[][][] arr = new int[m][n][2]; // 0 : 왼쪽에서옴 , 1 : 위에서 옴
		for (int i = 0; i < m; ++i) {
			if (cityMap[i][0] != 1) {
				arr[i][0][1] = 1;
			} else {
				break;
			}
		}
		for (int j = 0; j < n; ++j) {
			if (cityMap[0][j] != 1) {
				arr[0][j][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				// 왼쪽 길 상태에 따라서 -> 현재 가로 통행 상태
				switch (cityMap[i][j - 1]) {
				case 0:
					arr[i][j][0] = (arr[i][j - 1][0] + arr[i][j - 1][1]) % MOD;
					break;
				case 2:
					arr[i][j][0] = arr[i][j - 1][0];
					break;
				}
				// 윗 길 상태에 따라서 -> 현재 세로 통행 상태
				switch (cityMap[i - 1][j]) {
				case 0:
					arr[i][j][1] = (arr[i - 1][j][0] + arr[i - 1][j][1]) % MOD;
					break;
				case 2:
					arr[i][j][1] = arr[i - 1][j][1];
					break;
				}
			}
		}
		return (arr[m - 1][n - 1][0] + arr[m - 1][n - 1][1])%MOD;
	}
}

public class two {
	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int[][] cityMap = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Solution2 sol = new Solution2();
		System.out.println(sol.solution(m, n, cityMap));
	}
}
