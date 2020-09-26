public class JadenCase_문자열_만들기 {
	static
	class Solution {
	      public String solution(String s) {
	          StringBuilder sb = new StringBuilder();
	          if(isLower(s.charAt(0))){
	              sb.append((char)(s.charAt(0) & 0xDF));
	          }else{
	              sb.append(s.charAt(0));
	          }
	          for(int i = 1; i < s.length(); ++i){
	                if(s.charAt(i-1)==' '){
	                    if(isLower(s.charAt(i))){
	                        sb.append((char)(s.charAt(i) & 0xDF));               
	                    }else{
	                        sb.append(s.charAt(i));
	                    }
	                }else{
	                    if(isUpper(s.charAt(i))){
	                        sb.append((char)(s.charAt(i) | 0x20));
	                    }else{
	                        sb.append(s.charAt(i));
	                    }
	                }
	          }
	          return sb.toString();
	      }
	    public boolean isUpper(char c){
	        return c >= 'A' && c <= 'Z';
	    }
	    public boolean isLower(char c){
	        return c >= 'a' && c <= 'z';
	    }
	}
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
