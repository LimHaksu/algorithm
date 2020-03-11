package programmers;

public class 문자열을_정수로_바꾸기 {
	static
	class Solution {
		  public int solution(String s) {
		      int sign = 1;
		      int i = 0;
		      if(s.charAt(0)=='-'){
		          sign = -1;
		          i++;
		      }else if(s.charAt(0)=='+'){
		          i++;
		      }
		      int num = 0;
		      for(; i < s.length(); ++i){
		        num = num * 10  + (s.charAt(i)-'0');
		      }
		      return sign * num;
		  }
		}
}
