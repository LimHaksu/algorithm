import java.util.*;
class Solution {
	int answer = 0;
	public int solution(int n) {
		int[] arr = new int[n];
		dfs(arr,0);
		return answer;
	}
	boolean check(int[] arr, int cnt){
		for(int i = 0; i < cnt; ++i) {
			if(arr[i] == arr[cnt]) {
				return false;
			}
			if(Math.abs(arr[i]-arr[cnt]) == Math.abs(i-cnt)) {
				return false;
			}
		}
		return true;
	}
	void dfs(int[] arr, int cnt) {
		if(cnt == arr.length) {
			answer++;
			return;
		}
		for(int i = 0; i < arr.length; ++i) {
			arr[cnt] = i;
			if(check(arr,cnt)) {
				dfs(arr,cnt+1);
			}
		}
	}
}
public class N_Queen {
	public static void main(String[] args) {
		int n =12;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
