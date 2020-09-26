package programmers;
import java.util.*;

public class 전화번호_목록 {
	static class Solution {
	    public boolean solution(String[] phone_book) {
	    	Arrays.parallelSort(phone_book);
	        HashSet<String> set = new HashSet<String>();
	        for(int i = 0; i < phone_book.length; ++i) {
	        	StringBuilder sb = new StringBuilder();
	        	for(int j = 0; j < phone_book[i].length(); ++j) {
	        		sb.append(phone_book[i].charAt(j));
	        		if(set.contains(sb.toString())) {
	        			return false;
	        		}
	        	}
	        	set.add(phone_book[i]);
	        }
	        return true;
	    }
	}
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		Solution sol = new Solution();
		System.out.println(sol.solution(phone_book));
	}
}
