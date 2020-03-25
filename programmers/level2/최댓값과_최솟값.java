public class 최댓값과_최솟값 {
	static
	class Solution {
		  public String solution(String s) {
		      String[] arr = s.split(" ");
		      int max = Integer.MIN_VALUE;
		      int min = Integer.MAX_VALUE;
		      for(int i = 0; i < arr.length; ++i) {
		    	  int num = Integer.parseInt(arr[i]);
		    	  if(num > max) {
		    		  max = num;
		    	  }
		    	  if(num < min) {
		    		  min = num;
		    	  }
		      }
		      StringBuilder sb = new StringBuilder();
		      sb.append(String.valueOf(min)).append(' ').append(String.valueOf(max));
		      return sb.toString();
		  }
		}
	public static void main(String[] args) {
		String s = "1 2 3 4";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
