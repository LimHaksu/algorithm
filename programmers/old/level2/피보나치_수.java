public class 피보나치_수 {
	static
	class Solution {
		  public int solution(int n) {
		      int a = 0, b = 1;
		      int temp;
		      for(int i = 1; i < n; ++i) {
		    	temp = b;
		    	b = (b+a)%1234567;
		    	a = temp;
		      }
		      return b;
		  }
		}
	public static void main(String[] args) {
		int n = 3;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
