import java.io.*;
import java.util.*;

class Solution {
	int minLen;
    public int solution(String s) {
        minLen = s.length();
        for(int i = 1; i <= s.length()/2; ++i) {
        	int len = compress(s, i);
        	if(len < minLen) {
        		minLen = len;
        	}
        }
        return minLen;
    }
    int compress(String s, int size) {
    	String current = s.substring(0, size);
    	StringBuilder sb = new StringBuilder();
    	int count = 0;
    	int i = 0;
    	for(; i < s.length(); i += size) {
    		if(i+size <= s.length()) {
    			String temp = s.substring(i, i+size);
    			if(temp.equals(current)) {
    				count++;
    			}else {
    				if(count>1) {
    					sb.append(count);
    				}
    				sb.append(current);
    				current = temp;
    				count = 1;
    			}
    		}
    	}
    	if(count>1) {
    		sb.append(count).append(current);
    	}else {
    		sb.append(current);
    	}
    	if(i > s.length()) {
    		sb.append(s.substring(i-size,s.length()));
    	}
    	return sb.toString().length();
    }
}

public class 문자열압축 {
	public static void main(String[] args) {
		String s = "aabbaccc";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
