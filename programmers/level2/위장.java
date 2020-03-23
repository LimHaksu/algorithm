package programmers;
import java.util.*;
public class 위장 {
	static
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        for(int i = 0; i < clothes.length; ++i) {
	        	String category = clothes[i][1];
	        	if(!map.containsKey(category)) {
	        		map.put(category, 2);
	        	}else {
	        		map.put(category, map.get(category)+1);
	        	}
	        }
	        for(int num : map.values()) {
	        	answer *= num;
	        }
	        return answer-1;
	    }
	}
	public static void main(String[] args) {
		String[][]clothes = { {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Solution sol = new Solution();
		System.out.println(sol.solution(clothes));
	}
}
