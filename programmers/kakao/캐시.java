package A1;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    	if(cacheSize == 0) {
    		return cities.length * 5;
    	}
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        int idx;
        for(int i = 0; i < cities.length; ++i) {
        	String city = cities[i].toLowerCase();
        	if((idx = find(cache, city)) != -1){
        		cache.remove(idx);
        		answer++;
        	}else {
        		if(cache.size() >= cacheSize) {
        			cache.remove(0);
        		}
        		answer += 5;
        	}
        	cache.add(city);
        }
        return answer;
    }
    int find(ArrayList<String> cache, String city) {
    	for(int i = 0; i < cache.size(); ++i) {
    		if(cache.get(i).equals(city)) {
    			return i;
    		}
    	}
    	return -1;
    }
}

public class 캐시 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(sol.solution(cacheSize, cities));
	}
}
