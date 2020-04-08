import java.util.*;
class Solution {
	ArrayList<int[]> arr = new ArrayList<int[]>();
	public int[][] solution(int n) {
	  move(n, 1, 3, 2);
	  int[][] answer = new int[arr.size()][2];
	  for(int i = 0; i < answer.length; ++i) {
		  answer[i][0] = arr.get(i)[0];
		  answer[i][1] = arr.get(i)[1];
	  }
      return answer;
  }
  void move(int n, int from, int to, int temp) {
	  if(n==1) {
		  arr.add(new int[] {from, to});
		  return;
	  }
	  move(n-1, from, temp, to);
	  arr.add(new int[] {from, to});
	  move(n-1, temp, to, from);
  }
}
public class 하노이의_탑 {
	public static void main(String[] args) {
		int n = 2;
		Solution sol = new Solution();
		int[][] result = sol.solution(n);
		for(int i = 0; i < result.length; ++i) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
