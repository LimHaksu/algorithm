package programmers;

import java.util.Arrays;

public class 비밀지도 {
	static class Solution {
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
			for (int i = 0; i < n; ++i) {
				StringBuilder sb = new StringBuilder();
				int temp = arr1[i] | arr2[i];
				for (int j = 0; j < n; ++j) {
					sb.append(temp % 2 == 1 ? '#' : ' ');
					temp /= 2;
				}
				answer[i] = sb.reverse().toString();
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
	}
}
