import java.util.*;
public class 카펫 {
	static
	class Solution {
	    public int[] solution(int brown, int red) {
	        int[] answer = {};
	        int sumHW = brown/2+2;
	        int redSumHW = sumHW-4;
	        for(int w = redSumHW-1; w > 0; --w) {
	        	int h = redSumHW - w;
	        	if(h*w == red) {
	        		return new int[] {w+2, h+2};
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int brown = 10;
		int red = 2;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(brown, red)));
	}
}
