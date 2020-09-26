import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentTime = 0;
        Queue<int[]> q = new LinkedList<>();
        int currentWeight = 0;
        for(int i = 0; i < truck_weights.length; ++i) {
        	if(!q.isEmpty()) {
        		int[] front = q.peek();
        		while(front[0]+bridge_length <= currentTime) {
        			q.poll();
        			currentWeight -= front[1];
        			answer = front[0] + bridge_length+1;
        			if(!q.isEmpty()) {
        				front = q.peek();
        			}else {
        				break;
        			}
        		}
        	}
        	if(currentWeight + truck_weights[i] <= weight) {
        		q.add(new int[] {currentTime++, truck_weights[i]});
        		currentWeight += truck_weights[i];
        	}else {
        		while(currentWeight + truck_weights[i] > weight) {
        			int[] temp = q.poll();
        			currentTime = temp[0]+bridge_length;
        			answer = currentTime + 1;
        			currentWeight -= temp[1];
        		}
        		q.add(new int[] {currentTime++,truck_weights[i]});
        		currentWeight += truck_weights[i];
        	}
        }
        while(!q.isEmpty()) {
        	answer = q.poll()[0] + bridge_length+1;
        }
        return answer;
    }
}
public class 다리를_지나는_트럭 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		Solution sol = new Solution();
		System.out.println(sol.solution(bridge_length, weight, truck_weights));
	}
}
