import java.util.*;
public class 예상_대진표 {
	static
	class Solution
	{
	    public int solution(int n, int a, int b)
	    {
	    	int answer = 1;
	    	if(a > b) {
	    		int t = a;
	    		a = b;
	    		b = t;
	    	}
	    	while(!isMet(a,b)) {
	    		answer++;
	    		a = (a+1)/2;
	    		b = (b+1)/2;
	    	}
	        return answer;
	    }
	    static boolean isMet(int a, int b) {
	    	return a%2==1 && b-a == 1;
	    }
	}
	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		Solution sol = new Solution();
		System.out.println(sol.solution(n, a, b));
	}
}
