import java.util.*;

class Solution {
	public int[] solution(int n, long k) {
		k--;
		int[] answer = new int[n];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			arr.add(i + 1);
		}
		long np = 1;
		for (int i = 2; i < n; ++i) {
			np *= i;
		}
		long nn = n;
		int idx = -1;
		for (int i = 0; i < n; ++i) {
			idx = (int) ((k / np) % nn);
			answer[i] = arr.get(idx);
			arr.remove(idx);
			k = (k) % np;
			if (nn == 1) {
				break;
			}
			np /= (nn - 1);
			nn--;
		}
		return answer;
	}
}

public class 줄_서는_방법 {
	public static void main(String[] args) {
		int n = 4;
		int k = 7;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n, k)));
	}
}
