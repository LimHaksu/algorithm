import java.util.*;

class Solution {
	public int solution(int n, int[] money) {
		int[] arr = new int[n + 1];
		Arrays.sort(money);
		arr[0] = 1;
		for (int i = 0; i < money.length; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (j >= money[i]) {
					arr[j] = (arr[j] + arr[j - money[i]]) % 1000000007;
				}
			}
		}
		return arr[n];
	}
}

public class 거스름돈 {
	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		Solution sol = new Solution();
		System.out.println(sol.solution(n, money));
	}
}
