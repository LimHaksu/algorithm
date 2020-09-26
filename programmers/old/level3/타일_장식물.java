class Solution {
    public long solution(int N) {
        long s = 1;
        long l = 1;
        long answer = 4;
        long t;
        while(N-->1) {
        	answer += 2*l;
        	t = s;
        	s = l;
        	l += t;        			
        }
        return answer;
    }
}
public class 타일_장식물 {
	public static void main(String[] args) {
		int N = 5;
		Solution sol = new Solution();
		System.out.println(sol.solution(N));
	}
}
