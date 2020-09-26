import java.util.*;
public class 뉴스_클러스터링 {
	static
	class Solution {
		  public int solution(String str1, String str2) {
		      str1 = str1.toLowerCase();
		      str2 = str2.toLowerCase();
		      HashMap<String, Integer> map1 = new HashMap<>();
		      HashMap<String, Integer> map2 = new HashMap<>();
		      for(int i = 0; i < str1.length()-1; ++i) {
		    	  String temp = str1.substring(i,i+2);
		    	  if(isAlphabet(temp)) {
			    	  if(map1.containsKey(temp)) {
			    		  map1.put(temp, map1.get(temp)+1);
			    	  }else {
			    		  map1.put(temp, 1);
			    	  }
		    	  }
		      }
		      for(int i = 0; i < str2.length()-1; ++i) {
		    	  String temp = str2.substring(i,i+2);
		    	  if(isAlphabet(temp)) {
			    	  if(map2.containsKey(temp)) {
			    		  map2.put(temp, map2.get(temp)+1);
			    	  }else {
			    		  map2.put(temp, 1);
			    	  }
		    	  }
		      }
		      double answer;
		      if(map1.size()==0 && map2.size() == 0) {
		    	  answer = 1;
		      }else {
		    	  answer = (double)getIntersection(map1, map2)/getUnion(map1, map2);
		      }
		      answer *= 65536;
		      return (int)answer;
		  }
		  static boolean isAlphabet(String s) {
			  for(int i = 0; i < s.length(); ++i) {
				  if(s.charAt(i) > 'z' || s.charAt(i) < 'a') {
					  return false;
				  }
			  }
			  return true;
		  }
		  static int getUnion(HashMap<String,Integer> map1, HashMap<String,Integer> map2) {
			  HashMap<String, Integer> result = map1;
			  for(String word : map2.keySet()){
				  if(result.containsKey(word)) {
					  if(map2.get(word) > result.get(word)) {
						  result.put(word, map2.get(word));
					  }
				  }else{
					  result.put(word, map2.get(word));
				  }
			  }
			  int sum = 0;
			  for(int num : result.values()) {
				  sum += num;
			  }
			  return sum;
		  }
		  static int getIntersection(HashMap<String,Integer> map1, HashMap<String,Integer> map2) {
			  int result = 0;
			  for(String word : map1.keySet()) {
				  if(map2.containsKey(word)) {
					  result += Math.min(map1.get(word), map2.get(word));
				  }
			  }
			  return result;
		  }
		}
	public static void main(String[] args) {
		String str1 = "handshake";
		String str2 = "shake hands";
		Solution sol = new Solution();
		System.out.println(sol.solution(str1, str2));
	}
}
