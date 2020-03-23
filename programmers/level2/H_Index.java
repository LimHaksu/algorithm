package programmers;
import java.util.*;

public class H_Index {
	static
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        List<Integer> arr = new ArrayList<>(citations.length);
	        for(int i = 0; i < citations.length; ++i) {
	        	arr.add(citations[i]);
	        }
	        Collections.sort(arr, Collections.reverseOrder());
	        for(int i = 0; i < arr.size(); ++i) {
	        	int max = Math.min(i+1, arr.get(i));
	        	if(max > answer) {
	        		answer = max;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		Solution sol = new Solution();
		System.out.println(sol.solution(citations));
	}
}
