import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 0;
        int right = -2*w-1;
        for(int i = 0; i < stations.length; ++i) {
        	left = right+2*w+2;
        	right = stations[i]-w-1;
//        	System.out.println(left+", "+right);
        	if(left <= right) {
        		answer += (right-left)/(2*w+1)+1;
        	}
        }
        left = right+2*w+2;
        right = n;
//        System.out.println(left+", "+right);
        if(left <= right) {
    		answer += (right-left)/(2*w+1)+1;
        }
        return answer;
    }
}
public class 기지국_설치 {
	public static void main(String[] args) {
		int n = 11;
		int[] stations = {4,11};
		int w = 1;
		Solution sol = new Solution();
		System.out.println(sol.solution(n, stations, w));
	}
}
