class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        // i와 i+1 이 같으면 짝수개 점검
        for(int i = 0; i < s.length()-1;++i) {
        	if(s.charAt(i) == s.charAt(i+1)) {
        		int count = 2;
        		int left = i-1;
        		int right = i+2;
        		while(left >= 0 && right < s.length()) {
        			if(s.charAt(left) == s.charAt(right)) {
        				count += 2;
        				left--;
        				right++;
        			}else {
        				break;
        			}
        		}
        		if(count > answer) {
        			answer = count;
        		}
        	}
        }
        // 홀수개 점검
        for(int i = 0; i < s.length(); ++i) {
        	int count = 1;
        	int left =i-1;
        	int right = i+1;
        	while(left >= 0 && right < s.length()) {
        		if(s.charAt(left) == s.charAt(right)) {
        			count += 2;
        			left--;
        			right++;
        		}else {
        			break;
        		}
        	}
        	if(count > answer) {
        		answer = count;
        	}
        }
        return answer;
    }
}
public class 가장_긴_팰린드롬 {
	public static void main(String[] args) {
		String s = "abcdcba";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
