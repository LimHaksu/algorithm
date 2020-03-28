class Solution {
	char[] ntoc = { 'A', 'B', 'C', 'D', 'E', 'F' };

	public String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();
		int len = (t - 1) * m + p;
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while (sb.length() < len) {
			sb.append(toNthNum(num++, n));
		}
		for(int i = 0; i < t; ++i) {
			answer.append(sb.charAt(i*m+p-1));
		}
		return answer.toString();
	}

	String toNthNum(int num, int e) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			int temp = num % e;
			if (temp >= 10) {
				sb.append(ntoc[temp - 10]);
			} else {
				sb.append(num % e);
			}
			num /= e;
		}
		if (sb.length() == 0) {
			sb.append(0);
		}

		return sb.reverse().toString();
	}
}

public class n진수_게임 {
	public static void main(String[] args) {
		int n = 2, t = 4, m = 2, p = 1;
		Solution sol = new Solution();
		System.out.println(sol.solution(n, t, m, p));
	}
}
