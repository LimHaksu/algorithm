package programmers;
public class 다트_게임 {
	static
	class Solution {
		  public int solution(String dartResult) {
		      int answer = 0;
		      int[] score = new int[3];
		      int scoreIdx = -1;
		      for(int idx = 0; idx < dartResult.length(); ++idx) {
		    	  if(dartResult.charAt(idx)=='1') {
		    		  if(dartResult.charAt(idx+1)=='0') {
		    			  idx++;
		    			  score[++scoreIdx] = 10;
		    		  }else {
		    			  score[++scoreIdx] = 1;
		    		  }
		    	  }else if(dartResult.charAt(idx) >= '2' && dartResult.charAt(idx) <= '9' || dartResult.charAt(idx) == '0') {
		    		  score[++scoreIdx] = dartResult.charAt(idx) - '0';
		    	  }else {
		    		  switch(dartResult.charAt(idx)) {
		    		  case 'S':
		    			  break;
		    		  case 'D':
		    			  score[scoreIdx] = score[scoreIdx]*score[scoreIdx];
		    			  break;
		    		  case 'T':
		    			  score[scoreIdx] = score[scoreIdx]*score[scoreIdx]*score[scoreIdx];
		    			  break;
		    		  case '*':
		    			  if(scoreIdx >=1) {
		    				  score[scoreIdx-1] *= 2;
		    			  }
		    			  score[scoreIdx] *= 2;
		    			  break;
		    		  case '#':
		    			  score[scoreIdx] *= -1;
		    			  break;
		    		  }
		    	  }
		      }
		      for(int i = 0; i < score.length; ++i) {
		    	  answer += score[i];
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		Solution sol = new Solution();
		System.out.println(sol.solution(dartResult));
	}
}
