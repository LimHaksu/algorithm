import java.util.*;
public class 괄호_변환 {
	static
	class Solution {
	    public String solution(String p) {
	    	
	        // 1
	        if(p.equals("")) {
	        	return p;
	        }
	        if(checkCorrect(p)) {
	    		return p;
	    	}
	        //2
	        int idx = findIdx(p);
	        String u = p.substring(0,idx+1);
	        String v = p.substring(idx+1, p.length());
	        //3
	        StringBuilder sb = new StringBuilder();
	        if(checkCorrect(u)) {
	        	//3-1
	        	return sb.append(u).append(solution(v)).toString();
	        }
	        //4
	        //4-1
	        sb.append('(');
	        //4-2
	        sb.append(solution(v));
	        //4-3
	        sb.append(')');
	        //4-4
	        sb.append(reverse(new StringBuilder(u.substring(1,u.length()-1))));
	        //4-5
	        return sb.toString();
	    }
	    String reverse(StringBuilder sb) {
	    	for(int i = 0; i < sb.length(); ++i) {
	    		if(sb.charAt(i)=='(') {
	    			sb.setCharAt(i, ')');
	    		}else {
	    			sb.setCharAt(i, '(');
	    		}
	    	}
	    	return sb.toString();
	    }
	    boolean checkCorrect(String w) {
	    	if(w.charAt(0)==')') {
	    		return false;
	    	}
	    	int top = 1;
	    	for(int i = 1; i < w.length(); ++i) {
	    		if(w.charAt(i)=='(') {
	    			top++;
	    		}else {
	    			if(top>0) {
	    				top--;
	    			}else {
	    				return false;
	    			}
	    		}
	    	}
	    	return top==0;
	    }
	    //0~ idx에서 균형잡힌 문자열인 idx 반환
	    int findIdx(String w) {
	    	int countL = 0, countR = 0;
	    	for(int i = 0; i < w.length(); ++i) {
	    		if(w.charAt(i) == '(') {
	    			countL++;
	    		}else {
	    			countR++;
	    		}
	    		if(countL == countR) {
	    			return i;
	    		}
	    	}
	    	return w.length()-1;
	    }
	}
	public static void main(String[] args) {
		String p = "()))((()";
		Solution sol = new Solution();
		System.out.println(sol.solution(p));
	}
}
