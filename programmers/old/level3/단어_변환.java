class Solution {
	int answer = Integer.MAX_VALUE;
	String t;
    public int solution(String begin, String target, String[] words) {
        t = target;
        boolean[] visited = new boolean[words.length];
        dfs(begin, words,visited, 0);
        if(answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }
    void dfs(String current, String[] words, boolean[] visited, int count) {
    	if(current.equals(t)) {
    		if(count < answer) {
    			answer = count;
    		}
    		return;
    	}
    	for(int i = 0; i < visited.length; ++i) {
    		if(!visited[i] && countDiff(current,words[i])==1) {
    			visited[i] = true;
    			dfs(words[i], words, visited, count+1);
    			visited[i] = false;
    		}
    	}
    }
    int countDiff(String a, String b) {
    	int count = 0;
    	for(int i = 0; i < a.length(); ++i) {
    		if(a.charAt(i)!=b.charAt(i)) {
    			count++;
    		}
    	}
    	return count;
    }
}
public class 단어_변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		Solution sol = new  Solution();
		System.out.println(sol.solution(begin, target, words));
	}
}
