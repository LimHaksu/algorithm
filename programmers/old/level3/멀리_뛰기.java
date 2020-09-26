class Solution {
	public long solution(int n) {
		if (n == 1) {
			return 1;
		}
		long[] arr = new long[n];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i < n; ++i) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}
		return arr[n - 1];
	}
}

public class 멀리_뛰기 {
	public static void main(String[] args) {
		int n = 4;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
