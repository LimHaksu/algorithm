import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[progresses.length];
        for(int i = 0; i < progresses.length; ++i) {
        	arr[i] = (100-progresses[i])/speeds[i];
        	if((100-progresses[i])%speeds[i] > 0) {
        		arr[i]++;
        	}
        }
        int current = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; ++i) {
        	if(arr[i] <= current) {
        		count++;
        	}else {
        		list.add(count);
        		current = arr[i];
        		count = 1;
        	}
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; ++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}

public class 기능개발 {
	public static void main(String[] args) throws Exception{
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
	}
}
