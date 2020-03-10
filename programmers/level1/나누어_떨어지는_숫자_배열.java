package programmers;

import java.util.*;

public class 나누어_떨어지는_숫자_배열 {
	static class Solution {
		public int[] solution(int[] arr, int divisor) {
			ArrayList<Integer> arrList = new ArrayList<Integer>();
			for(int a : arr) {
				if(a%divisor==0) {
					arrList.add(a);
				}
			}
			Collections.sort(arrList);
			int[] answer = new int[arrList.size()];
			for(int i = 0; i < answer.length; ++i) {
				answer[i] = arrList.get(i);
			}
			if(answer.length == 0) {
				answer = new int[]{-1};
			}
			return answer;
		}
	}
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(arr, divisor)));
	}
}
