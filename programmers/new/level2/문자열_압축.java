import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); ++i) {
        	int shortenS = shorten(s, i);
        	if(shortenS < answer) {
        		answer = shortenS;
        	}
        }
        return answer;
    }
    int shorten(String s, int size) {
    	int currentCount = 1;
    	StringBuilder sb = new  StringBuilder();
    	int ni = 0;
    	for(int i = 0; i < s.length()-size; i+=size) {
    		ni = i+size;
    		boolean equal = true;
    		for(int j = 0; j < size; ++j) {
    			if(ni+j == s.length()) {
    				equal = false;
    				break;
    			}
    			if(s.charAt(i+j) != s.charAt(ni+j)) {
    				equal = false;
    				break;
    			}
    		}
    		if(equal) {
    			currentCount++;
    		}else {
    			if(currentCount>1) {
    				sb.append(currentCount);
    			}
    			for(int j = 0; j < size; ++j) {
    				sb.append(s.charAt(i+j));
    			}
    			currentCount = 1;
    		}
    	}
    	if(currentCount>1) {
			sb.append(currentCount);
		}
		for(; ni < s.length(); ++ni) {
			sb.append(s.charAt(ni));
		}
		return sb.length();
    }
}
public class 문자열_압축 {
	public static void main(String[] args) throws Exception{
		String s = "x";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
