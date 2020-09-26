import java.util.*;

class Solution {
	public int[] solution(int n, int s) {
		if(s/n==0) {
			return new int[] {-1};
		}
		int[] answer = new int[n];
		int t = s / n;
		int r = s - t * n;
		for (int i = 0; i < n; ++i) {
			answer[i] = t;
		}
		for (int i = n - 1; n - r <= i; --i) {
			answer[i]++;
		}
		return answer;
	}
}

public class 최고의_집합 {
	public static void main(String[] args) {
		int n = 5;
		int s = 3;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n, s)));
	}
}
