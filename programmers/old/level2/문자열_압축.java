package programmers;

public class 문자열_압축 {
	static class Solution {
		public int compress(String s, int n) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			while (idx < s.length()) {
				// 현재 문자
				int count = 1;
				StringBuilder current = new StringBuilder();
				for (int i = 0; i < n && idx < s.length(); ++i) {
					current.append(s.charAt(idx++));
				}
				// 다음 문자
				while (idx < s.length()) {
					StringBuilder next = new StringBuilder();
					int len = 0;
					for (int i = 0; i < n && idx < s.length(); ++i, ++len) {
						next.append(s.charAt(idx++));
					}
					if (current.toString().equals(next.toString())) {
						count++;
					} else {
						idx -= len;
						break;
					}
				}
				if (count == 1) {
					sb.append(current);
				} else {
					sb.append(count).append(current);
				}
			}
			return sb.length();
		}

		public int solution(String s) {
			int answer = compress(s, 1);
			for (int i = 1; i <= s.length()/2+1 ; ++i) {
				int comp = compress(s, i);
				if (comp < answer) {
					answer = comp;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		String s = "abcabcdede";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
