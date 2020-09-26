package programmers;

public class 조이스틱 {
	static
	class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < name.length(); ++i) {
	        	sb.append("A");
	        }
	        answer = dfs(sb,name,0,0);
	        return answer;
	    }
	    int dfs(StringBuilder sb, String name, int count, int currentIdx) {
	    	if(sb.toString().equals(name)) {
	    		return count;
	    	}
	    	int rCount = Integer.MAX_VALUE;
	    	int lCount = Integer.MAX_VALUE;
	    	int rIdx = findRightIdx(currentIdx, sb, name);
	    	int lIdx = findLeftIdx(currentIdx, sb, name);
	    	if(rIdx != -1) {
	    		char currentChar = sb.charAt(rIdx);
	    		int d = diff(sb.charAt(rIdx), name.charAt(rIdx), 26);
	    		sb.setCharAt(rIdx, name.charAt(rIdx));
	    		rCount = dfs(sb,name,count+diff(currentIdx, rIdx, name.length())+d,rIdx);
	    		sb.setCharAt(rIdx, currentChar);
	    	}
	    	if(lIdx != -1) {
	    		char currentChar = sb.charAt(lIdx);
	    		int d = diff(sb.charAt(lIdx), name.charAt(lIdx), 26);
	    		sb.setCharAt(lIdx, name.charAt(lIdx));
	    		lCount = dfs(sb,name,count+diff(currentIdx, lIdx,  name.length())+d,lIdx);
	    		sb.setCharAt(lIdx, currentChar);
	    	}
	    	return Math.min(rCount, lCount);
	    }
	    int diff(int a, int b, int size) {
	    	if(a > b) {
	    		int temp = a;
	    		a = b;
	    		b = temp;
	    	}
	    	return Math.min(b-a, a+size-b);
	    }
	    int findRightIdx(int currentIdx, StringBuilder sb, String name) {
	    	for(int i = 0; i < name.length(); ++i) {
	    		int idx = currentIdx + i;
	    		if(idx >= name.length()) {
	    			idx -= name.length();
	    		}
	    		if(sb.charAt(idx) != name.charAt(idx)) {
	    			return idx;
	    		}
	    	}
	    	return -1;
	    }
	    int findLeftIdx(int currentIdx, StringBuilder sb, String name) {
	    	for(int i = 0; i < name.length(); ++i) {
	    		int idx = currentIdx - i;
	    		if(idx < 0) {
	    			idx += name.length();
	    		}
	    		if(sb.charAt(idx) != name.charAt(idx)) {
	    			return idx;
	    		}
	    	}
	    	return -1;
	    }
	}
	public static void main(String[] args) {
		String name = "JEROEN";
		Solution sol = new Solution();
		System.out.println(sol.solution(name));
	}
}
