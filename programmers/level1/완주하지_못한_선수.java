package programmers;
import java.io.*;
import java.util.*;

public class 완주하지_못한_선수 {
	static class Solution {
	    public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        HashMap<String, Integer> map = new HashMap<>();
	        for(String person : completion) {
	        	if(map.containsKey(person)) {
	        		map.replace(person, map.get(person)+1);
	        	}else {
	        		map.put(person, 1);
	        	}
	        }
	        for(String person : participant) {
	        	if(map.containsKey(person)) {
	        		map.replace(person, map.get(person)-1);
	        		if(map.get(person)==0) {
	        			map.remove(person);
	        		}
	        	}else {
	        		return person;
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution(); 
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(sol.solution(participant, completion));
	}
}
