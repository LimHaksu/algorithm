package programmers;

public class 하샤드_수 {
	static
	class Solution {
		  public boolean solution(int x) {
		      int sum = 0;
		      int temp = x;
		      while(temp > 0) {
		    	  sum += temp % 10;
		    	  temp /= 10;
		      }
		      return x%sum == 0;
		  }
		}
	public static void main(String[] args) {
		int arr = 10;
		Solution sol = new Solution();
		System.out.println(sol.solution(arr));
	}
}
