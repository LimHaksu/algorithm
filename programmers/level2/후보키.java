import java.util.*;
class Solution {
	static String[][] r;
	HashSet<String> candidate = new HashSet<>();
    public int solution(String[][] relation) {
        r = relation;
        for(int i = 1; i <= r[0].length; ++i) {
        	select(i);
        }
        return candidate.size();
    }
    void select(int k) {
    	boolean[] selected = new boolean[r[0].length];
    	dfs(selected, k, 0, 0);
    }
    void dfs(boolean[] selected, int k, int count, int idx) {
    	if(k==count) {
    		HashSet<String> set = new HashSet<>();
    		for(int i = 0; i < r.length; ++i) {
    			StringBuilder sb = new StringBuilder();
    			for(int j = 0; j < selected.length; ++j) {
    				if(selected[j]) {
    					sb.append(r[i][j]).append(',');
    				}
    			}
    			if(set.contains(sb.toString())) {
    				return;
    			}else {
    				set.add(sb.toString());
    			}
    		}
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < selected.length; ++i) {
    			if(selected[i]) {
    				sb.append(i).append(' ');
    			}
    		}
    		String temp = sb.toString();
    		for(String c : candidate) {
    			// temp가 c의 원소를 전 부 갖고 있으면 그냥 return
    			char[] cArr = c.toCharArray();
    			boolean check = true; // 갖고있다.
    			for(int i = 0; i < cArr.length; ++i) {
    				if(!temp.contains(""+cArr[i])) {
    					check = false;
    				}
    			}
    			if(check) {
    				return;
    			}
    		}
    		candidate.add(temp);
    		return;
    	}
    	if(idx == selected.length)return;
    	selected[idx] = true;
    	dfs(selected, k, count+1, idx+1);
    	selected[idx] = false;
    	dfs(selected, k , count, idx+1);
    }
}
public class 후보키 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(sol.solution(relation));
	}
}
