package A2;

import java.io.*;
import java.util.*;

class Solution {
	int n;
	int[][] arr;
	boolean[][] ansCheck;
    public int[] solution(int[][] tarr) {
        int[] answer = {0,0};
        arr = tarr;
        n = arr.length;
        ansCheck = new boolean[n][n];
        dfs(0,0,n);
        for(int i = 0; i < n; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(ansCheck[i][j]) {
        			answer[arr[i][j]]++;
        		}
        	}
        }
        
        return answer;
    }
    
    
    void dfs(int sr, int sc, int size) {
    	boolean check = true;
    	int num = arr[sr][sc];
    	f: for(int i = sr; i < sr+size; ++i) {
    		for(int j = sc; j < sc+size; ++j) {
    			if(num != arr[i][j]) {
    				check = false;
    				break f;
    			}
    		}
    	}
    	if(check) {
    		ansCheck[sr][sc] = true;
    	}else {
    		int mr = sr + size/2;
    		int mc = sc + size/2;
    		dfs(sr, sc, size/2);
    		dfs(sr, mc, size/2);
    		dfs(mr, sc, size/2);
    		dfs(mr, mc, size/2);
    	}
    
    }
}

public class A2 {
	public static void main(String[] args) throws Exception{
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(arr)));
	}
}
