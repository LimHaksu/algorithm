package programmers;

import java.io.*;
import java.util.*;

public class 모의고사 {
	static class Solution {
		public int[] solution(int[] answers) {
			int[] count = {0,0,0};
			int len = answers.length;
			// 1번 (i%5)+1
			// 2번 i짝수2, i홀수:i%8 == 1:1, 3:3, 5:4, 7:5
			// 3번 (i%10)/2 3,1,2,4,5
			int[] three = {3,1,2,4,5};
			for(int i = 0; i < len; ++i) {
				if(i%5+1 == answers[i]) {
					count[0]++;
				}
				if(i%2==0 && answers[i]==2) {
					count[1]++;
				}else if(i%2==1) {
					switch(i%8) {
					case 1:
						if(answers[i]==1) {
							count[1]++;
						}
						break;
					case 3:
						if(answers[i]==3) {
							count[1]++;
						}
						break;
					case 5:
						if(answers[i]==4) {
							count[1]++;
						}
						break;
					case 7:
						if(answers[i]==5) {
							count[1]++;
						}
						break;
					}
				}
				if(three[(i%10)/2] == answers[i]) {
					count[2]++;
				}
			}
			int max = 0;
			ArrayList<Integer> answer = new ArrayList<>();
			for(int i = 0; i < 3; ++i) {
				if(count[i] > max) {
					max = count[i];
					answer = new ArrayList<Integer>();
					answer.add(i+1);
				}else if(count[i] == max) {
					answer.add(i+1);
				}
			}
			int size = answer.size();
			int[] ans = new int[size];
			for(int i = 0; i < size; ++i) {
				ans[i] = answer.get(i);
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] answers = {1,2,3,4,5};
		System.out.println(sol.solution(answers));
	}
}
