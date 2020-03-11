package programmers;
import java.util.*;
public class 문자열_내림차순으로_배치하기 {
	static class Solution {
		  public String solution(String s) {
		      String answer = "";
		      char[] arr = s.toCharArray();
		      ArrayList<Character> charArr = new ArrayList<Character>(arr.length);
		      for(char c : arr) {
		    	  charArr.add(c);
		      }
		      Collections.sort(charArr, Collections.reverseOrder());
		      StringBuffer sb = new StringBuffer();
		      for(int i = 0; i < arr.length; ++i) {
		    	  sb.append(charArr.get(i));
		      }
		      return sb.toString();
		  }
		}
	public static void main(String[] args) {
		String s="Zbcdefg";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
