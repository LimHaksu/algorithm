package programmers;

public class 짝수와_홀수 {
	static
	class Solution {
		  public String solution(int num) {
		      return num % 2 == 0 ? "Even" : "Odd";
		  }
		}
	public static void main(String[] args) {
		int num = 3;
		Solution sol = new Solution();
		System.out.println(sol.solution(num));
	}
}
