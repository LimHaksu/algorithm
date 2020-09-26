package programmers;

public class 가운데_글자_가져오기 {
	static
//	class Solution {
//		public String solution(String s) {
//			String answer = "";
//			int sLen = s.length();
//			if(sLen%2 == 0) {
//				answer += s.charAt(sLen/2-1);
//				answer += s.charAt(sLen/2);
//			}else {
//				answer += s.charAt(sLen/2);
//			}
//			return answer;
//		}
//	}
	class Solution{
		public String solution(String s) {
			if(s.length()==0) return "";
			return s.substring((s.length()-1)/2, s.length()/2+1);
		}
	}
	
	public static void main(String[] args) {
		String s = "qwer";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
