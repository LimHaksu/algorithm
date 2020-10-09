package A3;
import java.io.*;
import java.util.*;

class Solution {
	String[] userId;
	String[] bannedId;
	Set<String> set = new HashSet<String>();
    public int solution(String[] user_id, String[] banned_id) {
    	userId = user_id;
    	bannedId = banned_id;
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] checked = new boolean[user_id.length];
    	dfs(stack, checked, banned_id.length);
        return set.size();
    }
    
    void dfs(Stack<Integer> stack, boolean[] checked, int size) {
    	if(stack.size() == size) {
    		boolean check = true;
    		int bannedIdx = 0;
    		PriorityQueue<String> pq = new PriorityQueue<String>();
    		for(int idx : stack) {
    			if(!checkId(userId[idx], bannedId[bannedIdx++])) {
    				check = false;
    				break;
    			}else {
    				pq.add(userId[idx]);
    			}
    		}
    		StringBuilder sb = new StringBuilder();
    		if(check) {
    			while(!pq.isEmpty()) {
    				String s = pq.poll();
    				sb.append(s).append(',');
    			}
    			set.add(sb.toString());
    		}
    		return;
    	}
    	for(int i = 0; i < checked.length; ++i) {
    		if(!checked[i]) {
    			checked[i] = true;
    			stack.push(i);
    			dfs(stack, checked, size);
    			stack.pop();
    			checked[i] = false;
    		}
    	}
    }
    
    boolean checkId(String user, String banned) {
    	if(user.length() != banned.length()) {
    		return false;
    	}
    	for(int i = 0; i < user.length(); ++i) {
    		if(banned.charAt(i) == '*') {
    			continue;
    		}
    		if(user.charAt(i) != banned.charAt(i)) {
    			return false;
    		}
    	}
    	return true;
    }
}
public class 불량_사용자 {
	public static void main(String[] args) throws Exception{
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		Solution sol = new Solution();
		System.out.println(sol.solution(user_id, banned_id));
	}
}
