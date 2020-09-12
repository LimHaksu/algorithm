import java.io.*;

import java.util.*;
class Solution {
    public String solution(String p) {
        return solve(p);
    }
    String solve(String s) {
    	if(s.equals("")) {
    		return "";
    	}
    	String[] uv = split(s);
    	String u = uv[0];
    	String v = uv[1];
    	if(isRightString(u)) {
    		return u + solve(v);
    	}else {
    		StringBuilder sb = new StringBuilder("");
    		sb.append('(');
    		sb.append(solve(v));
    		sb.append(')');
    		sb.append(removeFirstLastAndReverse(u));
    		return sb.toString();
    	}
    }
    
    String removeFirstLastAndReverse(String s) {
    	s = new StringBuilder(s.substring(1, s.length()-1)).toString();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) == '(') {
    			sb.append(')');
    		}else {
    			sb.append('(');
    		}
    	}
    	return sb.toString();
    }
    
    boolean isRightString(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		if(c == '(') {
    			stack.push(c);
    		}else {
    			if(stack.isEmpty()) {
    				return false;
    			}else {
    				stack.pop();
    			}
    		}
    	}
    	return stack.isEmpty();
    }
    
    String[] split(String s) {
    	StringBuilder sb1 = new StringBuilder("");
    	StringBuilder sb2 = new StringBuilder("");
    	int leftCount = 0;
    	int rightCount = 0;
    	int index = 0;
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) == '(') {
    			leftCount++;
    		}else if(s.charAt(i) == ')') {
    			rightCount++;
    		}
    		if(leftCount == rightCount) {
    			index = i;
    			break;
    		}
    	}
    	for(int i = 0; i <= index; ++i) {
    		sb1.append(s.charAt(i));
    	}
    	for(int i = index+1; i < s.length(); ++i) {
    		sb2.append(s.charAt(i));
    	}
    	return new String[] {sb1.toString(), sb2.toString()};
    }
}

public class 괄호변환 {
	public static void main(String[] args) {
		String p = "()))((()";
		Solution sol = new Solution();
		System.out.println(sol.solution(p));
	}
}
