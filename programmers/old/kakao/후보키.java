import java.io.*;
import java.util.*;

class Solution {
	String[][] relation;
	Set<String> candidateSet = new HashSet<>();
	boolean find = false;
    public int solution(String[][] rel) {
        relation = rel;
        for(int i = 1; i <= rel.length; ++i) {
        	boolean[] checked = new boolean[rel[0].length];
        	dfs(i, 0, checked, 0);
        }
        return candidateSet.size();
    }
    void dfsSub(int targetCount, int currentCount, boolean[] originalChecked, boolean[] checked, int idx) {
    	if(find) {
    		return;
    	}
    	if(targetCount == currentCount) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = 0; i < checked.length; ++i) {
    			if(checked[i]) {
    				sb.append(i).append(',');
    			}
    		}
    		String candidate = sb.toString();
    		if(candidateSet.contains(candidate)) {
    			find = true;;
    		}
    		return;
    	}
    	if(idx == checked.length) {
    		return;
    	}
    	if(originalChecked[idx]) {
    		checked[idx] = true;
    		dfsSub(targetCount, currentCount+1, originalChecked, checked, idx+1);
    		checked[idx] = false;
    	}
    	dfsSub(targetCount, currentCount, originalChecked, checked, idx+1);
    }
    void dfs(int targetCount, int currentCount, boolean[] checked, int idx) {
    	if(targetCount == currentCount) {
    		// x개 선택
    		Set<String> set = new HashSet<>();
    		for(int i = 0; i < relation.length; ++i) {
    			StringBuilder sb = new StringBuilder();
    			for(int j = 0; j < relation[i].length; ++j) {
    				if(checked[j]) {
    					sb.append(relation[i][j]).append(',');
    				}
    			}
    			String candidate = sb.toString();
    			if(set.contains(candidate)) {
    				return;
    			}else {
    				set.add(candidate);
    			}
    		}
    		
    		
    		StringBuilder candidate = new StringBuilder();
    		for(int i = 0; i < checked.length; ++i) {
    			if(checked[i]) {
    				candidate.append(i).append(',');
    			}
    		}
    		// if candidate 일부가 candidateSet 안에 없으면
    		find = false;
    		for(int i = 1; i <= targetCount; ++i) {
    			boolean[] newChecked = new boolean[checked.length];
    			dfsSub(i, 0, checked, newChecked, 0);
    		}
    		if(!find) {
    			candidateSet.add(candidate.toString());
    		}
    		return;
    	}
    	if(idx == checked.length) {
    		return;
    	}
    	checked[idx] = true;
    	dfs(targetCount, currentCount+1, checked, idx+1);
    	checked[idx] = false;
    	dfs(targetCount, currentCount, checked, idx+1);
    }
}

public class 후보키 {
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		Solution sol = new Solution();
		System.out.println(sol.solution(relation));
	}
}
