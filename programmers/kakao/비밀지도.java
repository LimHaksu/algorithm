package A1;

import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] charAnswer = new char[n][n];
        for(int i = 0; i < arr1.length; ++i) {
        	int item1 = arr1[i];
        	int item2 = arr2[i];
        	for(int j = 0; j < arr1.length; ++j) {
        		if(item1 % 2 == 1 || item2 % 2 == 1) {
        			charAnswer[i][n-1-j] = '#';
        		}else {
        			charAnswer[i][n-1-j] = ' ';
        		}
        		item1 /= 2;
        		item2 /= 2;
        	}
        }
        for(int i = 0; i < n; ++i) {
        	StringBuilder sb = new  StringBuilder();
        	for(int j = 0; j < n; ++j) {
        		sb.append(charAnswer[i][j]);
        	}
        	answer[i] = sb.toString();
        }
        return answer;
    }
}

public class 비밀지도 {
	public static void main(String[] args){
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
	}
}
