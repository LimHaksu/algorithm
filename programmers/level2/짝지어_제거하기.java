import java.util.*;
public class 짝지어_제거하기 {
	static
	class Solution
	{
	    public int solution(String s)
	    {
	        Stack<Character> stack = new Stack<>();
	        int len = s.length();
	        for(int i = 0; i < len; ++i) {
	        	if(stack.isEmpty()) {
	        		stack.push(s.charAt(i));
	        	}else {
	        		char c = s.charAt(i);
	        		if(c == stack.peek()) {
	        			stack.pop();
	        		}else {
	        			stack.push(c);
	        		}
	        	}
	        }
	        if(stack.isEmpty()) {
	        	return 1;
	        }
	        return 0;
	    }
	}
	public static void main(String[] args) {
		String s = "cdcd";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
