package programmers;
import java.util.*;

public class 자릿수_더하기 {
	static
	public class Solution {
	    public int solution(int n) {
	        int answer = 0;
			String sn = String.valueOf(n);
			for(int i = 0; i < sn.length(); ++i) {
				answer += sn.charAt(i)-'0';
			}
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int N = 123;
		Solution sol = new Solution();
		System.out.println(sol.solution(N));
	}
}
