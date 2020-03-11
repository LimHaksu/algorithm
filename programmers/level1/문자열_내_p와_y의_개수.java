package programmers;

public class 문자열_내_p와_y의_개수 {
	static
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        int len = s.length();
	        int count = 0;
	        for(int i = 0; i < len ; ++i) {
	        	if((s.charAt(i)|0x20)=='p') {
	        		count++;
	        	}else if((s.charAt(i)|0x20)=='y') {
	        		count--;
	        	}
	        }
	        return count==0;
	    }
	}
	public static void main(String[] args) {
		String s = "pPoooyY";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
