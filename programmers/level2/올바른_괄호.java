import java.io.*;
import java.util.*;
public class 올바른_괄호 {
	static
	class Solution {
	    boolean solution(String s) {
	        int top = -1;
	        for(int i = 0; i < s.length(); ++i) {
	        	char c = s.charAt(i);
	        	if(c == '(') {
	        		top++;
	        	}else {
	        		if(top >= 0) {
	        			top--;
	        		}else {
	        			return false;
	        		}
	        	}
	        }
	        if(top == -1)
	        	return true;
	        return false;
	    }
	}
	public static void main(String[] args) {
		String s = "()()";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
