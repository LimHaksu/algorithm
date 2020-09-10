package A1;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<String,Integer>();
        Map<String, Integer> map2 = new HashMap<String,Integer>();
        for(int i = 0; i < str1.length()-1; ++i) {
        	if(str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' && str1.charAt(i+1) >= 'a' && str1.charAt(i+1) <= 'z') {
        		String s = str1.substring(i,i+2);
        		if(map1.containsKey(s)) {
        			map1.replace(s, map1.get(s)+1);
        		}else {
        			map1.put(s,1);
        		}
        	}
        }
        for(int i = 0; i < str2.length()-1; ++i) {
        	if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' && str2.charAt(i+1) >= 'a' && str2.charAt(i+1) <= 'z') {
        		String s = str2.substring(i,i+2);
        		if(map2.containsKey(s)) {
        			map2.replace(s, map2.get(s)+1);
        		}else {
        			map2.put(s,1);
        		}
        	}
        }
        Map<String, Integer> intersection = new HashMap<>();
        Map<String,Integer> union = new HashMap<>();
        for(String s1: map1.keySet()) {
        	union.put(s1, map1.get(s1));
        	for(String s2: map2.keySet()) {
        		if(s1.equals(s2)) {
        			intersection.put(s1, Math.min(map1.get(s1),  map2.get(s2)));
        		}
        	}
        }
        for(String s2: map2.keySet()) {
        	if(union.containsKey(s2)) {
        		union.replace(s2,  Math.max(union.get(s2),  map2.get(s2)));
        	}else {
        		union.put(s2, map2.get(s2));
        	}
        }
        int interSum = 0;
        int unionSum = 0;
        for(int num : intersection.values()) {
        	interSum += num;
        }
        for(int num : union.values()) {
        	unionSum += num;
        }
        int answer = 65536;
        if(unionSum > 0) {
        	answer = interSum * 65536 / unionSum;
        }
        return answer;
    }
}

public class 뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		Solution sol = new Solution();
		System.out.println(sol.solution(str1, str2));
	}
}
