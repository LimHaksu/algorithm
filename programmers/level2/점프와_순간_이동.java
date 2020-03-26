import java.util.*;
public class 점프와_순간_이동 {
	static
	public class Solution {
	   public int solution(int n) {
		   int count = 0;
		   while(n > 0){
			  if(n%2==0) { 
				  n/=2;
			  }else {
				  count++;
				  n--;
				  n/=2;
			  }
		   }
		   return count;
	   }
	}
	public static void main(String[] args) {
		int N = 5000;
		Solution sol = new Solution();
		System.out.println(sol.solution(N));
	}
}
