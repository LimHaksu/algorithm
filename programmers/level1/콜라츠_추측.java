package programmers;

public class 콜라츠_추측 {
	static
	class Solution {
		  public int solution(int num) {
		      long temp = num;
		      for(int i = 0; i < 500; ++i) {
		           if(temp==1){
		                  return i;
		              }
		          if(temp % 2 == 0) {
		              temp /= 2;
		             
		          }else {
		              temp = temp * 3 + 1;
		          }
		      }
		      return -1;
		  }
		}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 6;
		System.out.println(sol.solution(n));
	}
}
