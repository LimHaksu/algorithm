class Solution {
	public int solution(int n) {
		if (n == 1) {
			return 1;
		}
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < n; ++i) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
		}
		return arr[n - 1];
	}
}

public class n2xn타일링 {
	public static void main(String[] args) {
		int n = 4;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
