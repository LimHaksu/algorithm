package A5;
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = 200_000_000;
        while(left <= right) {
        	int mid = (left + right) / 2;
        	if(check(stones, k, mid)) {
        		left = mid + 1;
        		answer = mid;
        	}else {
        		right = mid - 1;
        	}
        }
        return answer;
    }
    boolean check(int[] stones, int k, int height) {
    	for(int i = -1; i < stones.length; ) {
    		boolean find = false;
    		for(int j = 1; j <= k; ++j) {
				i++;
    			if(i == stones.length || stones[i]>= height) {
    				find = true;
    				break;
    			}
    		}
    		if(!find) {
    			return false;
    		}
    	}
    	return true;
    }
}

public class 징검다리_건너기 {
	public static void main(String[] args) throws Exception{
		int[] stones = {2,4,5,3,2,1,4,2,5,1};
		int k = 3;
		Solution sol = new Solution();
		System.out.println(sol.solution(stones, k));
	}
}
