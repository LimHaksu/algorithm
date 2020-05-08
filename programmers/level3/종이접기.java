import java.util.*;
class Solution {
	  public int[] solution(int n) {
		int[] arr = { 0 };
		for (int i = 1; i < n; ++i) {
			int[] temp = new int[arr.length * 2 + 1];
			int j = 0;
			for (int idx = 1; idx < temp.length; idx += 2) {
				temp[idx] = arr[j++];
			}
			for (int idx = 1; idx < temp.length; idx += 4) {
				temp[idx - 1] = 0;
				temp[idx + 1] = 1;
			}
			arr = temp;
		}
		return arr;
	}
}
public class 종이접기 {
	public static void main(String[] args) {
		int n  = 3;
		Solution sol = new  Solution();
		System.out.println(Arrays.toString(sol.solution(n)));
	}
}
