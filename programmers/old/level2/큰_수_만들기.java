package programmers;
public class 큰_수_만들기 {
	static
	class Solution{
		
	    public String solution(String number, int k) {
	    	int len = number.length();
	    	StringBuilder sb = new StringBuilder(number);
	    	int count = 0;
	    	for(int i = 0; i < sb.length()-1; ++i) {
	    		if(sb.charAt(i) < sb.charAt(i+1)) {
	    			sb.deleteCharAt(i);
	    			i -= 2;
	    			if(i <= -1) i = 0;
	    			count++;
	    			if(count == k) {
	    				break;
	    			}
	    		}
	    	}
	    	return sb.toString();
	    }
	}
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		Solution sol = new Solution();
		System.out.println(sol.solution(number, k));
	}
}
