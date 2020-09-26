package programmers;

import java.util.*;

public class 예산 {
	static class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;
			Arrays.sort(d);
			int idx = 0;
			while (idx < d.length && budget >= d[idx]) {
				budget -= d[idx++];
				answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] d = { 2,2,3,3 };
		int budget = 10;
		Solution sol = new Solution();
		System.out.println(sol.solution(d, budget));
	}
}
