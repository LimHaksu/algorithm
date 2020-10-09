package A1;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        	sb.append(n % 3);
        	n /= 3;
        }
        int three = 1;
        for(int i = sb.length()-1; i >= 0; --i) {
        	answer += (sb.charAt(i)-'0') * three;
        	three *= 3;
        }
        return answer;
    }
}
public class A1 {
	public static void main(String[] args) {
		int n = 45;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
