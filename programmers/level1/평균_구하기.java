package programmers;

public class 평균_구하기 {
	static
	class Solution {
		  public double solution(int[] arr) {
		      int sum = 0;
		      for(int i = 0;i < arr.length; ++i) {
		    	  sum += arr[i];
		      }
		      return (double) sum / arr.length;
		  }
		}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = { 1,2,3,4};
		System.out.println(sol.solution(arr));
	}
}
