package programmers;
public class 쇠막대기 {
	static
	class Solution {
	    public int solution(String arrangement) {
	        int answer = 0;
	        int count = 0;
	        for(int i = 0; i < arrangement.length(); ++i) {
	        	switch(arrangement.charAt(i)) {
	        	case '(':
	        		if(arrangement.charAt(i+1) == ')') {
	        			answer += count;
	        			i++;
	        		}else {
	        			count++;
	        		}
	        		break;
	        	case ')':
	        		count--;
	        		answer++;
	        		break;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
//		String arrangement = "(())";
		String arrangement = "()(((()())(())()))(())";
		Solution sol = new Solution();
		System.out.println(sol.solution(arrangement));
	}
}
