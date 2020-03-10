package programmers;

public class n2016년 {
	static class Solution {
		public String solution(int a, int b) {
			int days = b-1;
			int[] month = {0,0,31,29,31,30,31,30,31,31,30,31,30};
			for(int i = 1; i <= a; ++i) {
				days += month[i];
			}
			String[] weekDay = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
			return weekDay[days%7];
		}
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		Solution sol = new Solution();
		System.out.println(sol.solution(a, b));
	}
}
