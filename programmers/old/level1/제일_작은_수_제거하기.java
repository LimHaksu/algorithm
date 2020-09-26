package programmers;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
	static
	class Solution {
		  public int[] solution(int[] arr) {
			  if(arr.length==1) {
				  return new int[] {-1};
			  }
			  int minNum = Integer.MAX_VALUE;
		      int minIdx = -1;
		      for(int i = 0; i < arr.length; ++i) {
		    	  if(minNum > arr[i]) {
		    		  minNum = arr[i];
		    		  minIdx = i;
		    	  }
		      }
		      int[] answer = new int[arr.length-1];
		      for(int i = 0, arrIdx = 0; arrIdx < arr.length; ++arrIdx) {
		    	  if(arrIdx != minIdx) {
		    		  answer[i++] = arr[arrIdx];
		    	  }
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(arr)));
	}
}
