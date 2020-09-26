package programmers;

import java.util.*;

public class 스킬트리 {
	static class Solution {
		public int solution(String skill, String[] skill_trees) {
			int answer = 0;
			for(int i = 0; i < skill_trees.length; ++i) {
				String st = skill_trees[i];
				int skill_idx = 0;
				boolean check = true;
				f: for(int j = 0; j < st.length(); ++j) {
					if(skill.charAt(skill_idx)!=st.charAt(j)) {
						if(checkContains(skill, st.charAt(j))) {
							check = false;
							break f;
						}
					}else {
						skill_idx++;
						if(skill_idx==skill.length()) {
							break;
						}
					}
				}
				if(check) {
					answer++;
				}
			}
			return answer;
		}
		boolean checkContains(String str, char c) {
			for(int i = 0; i < str.length(); ++i) {
				if(str.charAt(i)==c) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		String skill = "CBD";
//		String[] skill_trees = {"AECB"};
		String[] skill_trees = { "BACDE" , "CBADF", "AECB", "BDA"};
		Solution sol = new Solution();
		System.out.println(sol.solution(skill, skill_trees));
	}
}
