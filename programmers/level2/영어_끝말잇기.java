import java.util.*;
public class 영어_끝말잇기 {
	static
	class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];
	        HashSet<String> set = new HashSet<>();
	        int idx = -1;
	        set.add(words[0]);
	        for(int i = 1; i < words.length; ++i) {
	        	if(set.contains(words[i])) {
	        		idx = i;
	        		break;
	        	}else {
	        		if(words[i].charAt(0)==words[i-1].charAt(words[i-1].length()-1)) {
	        			set.add(words[i]);
	        		}else {
	        			idx = i;
	        			break;
	        		}
	        	}
	        }
	        if(idx!=-1){
	        	answer[0] = idx%n+1;
	        	answer[1] = idx/n+1;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n, words)));
	}
}
