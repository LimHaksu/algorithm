import java.util.*;

class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		for(int i = 0; i < cities.length; ++i) {
			cities[i] = cities[i].toLowerCase();
		}
		LinkedList<String> cache = new LinkedList<>();
		int idx;
		for (int i = 0; i < cities.length; ++i) {
			if ((idx = isHit(cache, cities[i])) != -1) {
				cache.remove(idx);
				answer++;
			} else {
				if (cacheSize > 0 && cache.size() == cacheSize) {
					cache.remove(cacheSize - 1);
				}
				answer += 5;
			}
			if(cacheSize > 0) {
				cache.add(0, cities[i]);
			}
		}
		return answer;
	}

	int isHit(List<String> cache, String city) {
		for (int i = 0; i < cache.size(); ++i) {
			if (cache.get(i).equals(city)) {
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
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		System.out.println(sol.solution(cacheSize, cities));
	}
}
