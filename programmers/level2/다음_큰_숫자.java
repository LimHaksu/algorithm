import java.util.*;

public class 다음_큰_숫자 {
	static class Solution {
		public int solution(int n) {
			StringBuilder sb = new StringBuilder();
			while (n > 0) {
				sb.append(n % 2);
				n /= 2;
			}
			sb = sb.reverse();
			int totalCount = 0, oneCount = 0;
			int idx = -1;
			for (int i = sb.length() - 1; i > 0; --i) {
				if (sb.charAt(i) == '1') {
					if (sb.charAt(i - 1) == '0') {
						idx = i + 1;
						totalCount = sb.length()-1 - i;
						sb.setCharAt(i - 1, '1');
						sb.setCharAt(i, '0');
						break;
					} else {
						oneCount++;
					}
				}
			}
			if (idx == -1) {
				totalCount = sb.length()-1;
				sb.setCharAt(0, '0');
				sb.insert(0, '1');
				idx = 2;
			}
			int zeroCount = totalCount - oneCount;
			while (zeroCount-- > 0) {
				sb.setCharAt(idx, '0');
				idx++;
			}
			while (oneCount-- > 0) {
				sb.setCharAt(idx, '1');
				idx++;
			}
			int answer = 0;
			int term = 1;
			for(int i = sb.length()-1; i >= 0; --i) {
				answer += term * (sb.charAt(i)-'0');
				term *= 2;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int n = 24;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
