package programmers;
import java.util.*;
import java.io.*;

public class 체육복 {
	static
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        int[] count = new int[n+2];
	        Arrays.fill(count, 1);
	        count[n+1] = 0;
	        int reserveLength = reserve.length;
	        for(int i = 0; i < reserveLength; ++i) {
	        	count[reserve[i]]++;
	        }
	        int lostLength = lost.length;
	        for(int i = 0; i < lostLength; ++i) {
	        	count[lost[i]]--;
	        }
	        for(int i = 1; i <= n; ++i) {
	        	if(count[i]==0) {
	        		if(count[i-1]>1) {
	        			count[i-1]--;
	        			count[i]++;
	        		}else if(count[i+1]>1) {
	        			count[i+1]--;
	        			count[i]++;
	        		}
	        	}
	        }
	        for(int i = 1; i <= n; ++i) {
	        	if(count[i]>=1) {
	        		answer++;
	        	}
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		Solution sol = new Solution();
		System.out.println(sol.solution(n, lost, reserve));
	}
	
}
