package programmers;
import java.util.*;
public class 정수_제곱근_판별 {
	static
	class Solution {
		  public long solution(long n) {
		      long root = (long) Math.sqrt(n); 
		      if(root*root == n) {
		    	  return (root+1)*(root+1);
		      }else {
		    	  return -1;
		      }
		  }
		}
	public static void main(String[] args) {
		int n = 121;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
