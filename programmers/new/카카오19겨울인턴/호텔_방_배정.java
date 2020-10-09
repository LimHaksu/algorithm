import java.io.*;
import java.util.*;

class Solution {
	Map<Long, Long> root = new HashMap<>();
    
	public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for(int i = 0; i < room_number.length; ++i) {
        	answer[i] = root.get(find(room_number[i]));
        	union(answer[i], answer[i]+1);
        }
        return answer;
    }

	void union(long u, long v) {
		u = find(u);
		v = find(v);
		if(u > v) {
			root.put(v, u);
		}else if(u < v) {
			root.put(u, v);
		}
	}
	
	long find(long u) {
		if(!root.containsKey(u)) {
			root.put(u, u);
			return u;
		}else {
			long p = root.get(u);
			if(p == u) {
				return u;
			}
			root.put(u, find(root.get(u)));
			return root.get(u);
		}
	}
}

public class 호텔_방_배정 {
	public static void main(String[] args) {
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(k, room_number)));
	}
}
