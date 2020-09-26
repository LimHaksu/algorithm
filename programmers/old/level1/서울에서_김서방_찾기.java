package programmers;

public class 서울에서_김서방_찾기 {
	static
	class Solution {
		  public String solution(String[] seoul) {
		      String answer = "";
		      for(int i = 0; i < seoul.length; ++i) {
		    	  if(seoul[i].equals("Kim")) {
		    		  return "김서방은 "+i+"에 있다";
		    	  }
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		Solution sol = new Solution();
		System.out.println(sol.solution(seoul));
	}
}
