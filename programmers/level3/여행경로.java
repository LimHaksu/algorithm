import java.util.*;
class Solution {
	int size;
	String[][] gTickets;
	String[] ans = new String[0];
    public String[] solution(String[][] tickets) {
        size = tickets.length;
        gTickets = tickets;
        Stack<String> stack = new Stack<>();
        boolean[] visited = new boolean[size];
        stack.push("ICN");
        for(int i = 0; i < size; ++i) {
        	if(tickets[i][0].equals("ICN")) {
        		visited[i] = true;
        		stack.push(tickets[i][1]);
        		dfs(visited,tickets[i][1],stack);
        		stack.pop();
        		visited[i] = false;
        	}
        }
        return ans;
    }
    int compare(String[] arr1, String[] arr2) {
    	if(arr1.length < arr2.length) {
    		return 1;
    	}
    	for(int i = 0; i < arr1.length; ++i) {
    		if(arr1[i].compareTo(arr2[i]) <0) {
    			return -1;
    		}else if(arr1[i].compareTo(arr2[i]) > 0) {
    			return 1;
    		}
    	}
    	return 0;
    }
    void dfs(boolean[] visited, String current, Stack<String> stack) {
    	if(stack.size() == size+1) {
    		String[] arr = new String[size+1];
    		int idx = 0;
    		for(String s : stack) {
    			arr[idx++] = s;
    		}
    		if(compare(ans, arr) > 0) {
    			ans = arr;
    		}
    		return;
    	}
    	for(int i = 0; i < size; ++i) {
    		if(!visited[i] && gTickets[i][0].equals(current)) {
    			visited[i] = true;
    			stack.push(gTickets[i][1]);
    			dfs(visited, gTickets[i][1], stack);
    			stack.pop();
    			visited[i] = false;
    		}
    	}
    }
}
public class 여행경로 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(tickets)));
	}
}
