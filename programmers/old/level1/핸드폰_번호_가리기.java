package programmers;

public class 핸드폰_번호_가리기 {
	static
	class Solution {
		  public String solution(String phone_number) {
//		      StringBuilder sb = new StringBuilder(phone_number);
//		      for(int i = sb.length()-5; i >= 0; --i) {
//		    	  sb.setCharAt(i, '*');
//		      }
//		      return sb.toString();
			  char[] arr = phone_number.toCharArray();
			  for(int i = arr.length-5; i >= 0; --i) {
				  arr[i] = '*';
			  }
			  return new String(arr);
		  }
		};
	public static void main(String[] args) {
		Solution sol = new Solution();
		String phone_number = "01033334444";
		System.out.println(sol.solution(phone_number));
	}
}
