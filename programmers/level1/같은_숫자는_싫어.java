package programmers;

import java.util.*;

public class 같은_숫자는_싫어 {
	static public class Solution {
		public int[] solution(int[] arr) {
			int currentNum = arr[0];
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(arr[0]);
			for (int i = 1; i < arr.length; ++i) {
				if (currentNum != arr[i]) {
					currentNum = arr[i];
					temp.add(arr[i]);
				}
			}
			int[] answer = new int[temp.size()];
			for (int i = 0; i < answer.length; ++i) {
				answer[i] = temp.get(i);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(arr)));
	}
}
