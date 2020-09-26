package A1;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int idx = -1;
        for(int i = 0; i < dartResult.length(); ++i) {
        	char c = dartResult.charAt(i);
        	if(c >= '0' && c <= '9') {
        		idx++;
        		if(c == '1' && dartResult.charAt(i+1) == '0') {
        			score[idx] = 10;
        			i++;
        		}else {
        			score[idx] = c - '0';
        		}
        	}else{
        		switch(c) {
        		case 'S':
        			break;
        		case 'D':
        			score[idx] *= score[idx];
        			break;
        		case 'T':
        			score[idx] *= score[idx] * score[idx];
        			break;
        		case '*':
        			score[idx] *= 2;
        			if(idx > 0) {
        				score[idx-1] *= 2;
        			}
        			break;
        		case '#':
        			score[idx] *= -1;
        			break;
        		}
        	} 
        }
        System.out.println(Arrays.toString(score));
        for(int i = 0; i < 3; ++i) {
        	answer += score[i];
        }
        return answer;
    }
}

public class 다트게임 {
	public static void main(String[] args) {
		String dartResult = "1D2S3T*";
		int answer = 37;
		Solution sol = new Solution();
		System.out.println(sol.solution(dartResult));
	}
}
