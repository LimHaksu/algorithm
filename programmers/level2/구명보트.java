import java.util.*;

public class 구명보트 {
	static class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			int left = 0, right = people.length - 1;
			boolean[] check = new boolean[people.length];
			Arrays.sort(people);
			while (left < right) {
				if (people[left] + people[right] <= limit) {
					answer++;
					check[left] = check[right] = true;
					left++;
				}
				right--;
			}
			for (int i = 0; i < check.length; ++i) {
				if (!check[i]) {
					answer++;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] people = { 70, 80, 50 };
		int limit = 100;
		Solution sol = new Solution();
		System.out.println(sol.solution(people, limit));
	}
}
