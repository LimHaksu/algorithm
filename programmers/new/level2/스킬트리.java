class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillIdx = new int[128];
        for(int i = 'A'; i <= 'Z'; ++i){
            skillIdx[i] = -1;
        }
        for(int i = 0; i < skill.length(); ++i){
            char c = skill.charAt(i);
            skillIdx[c] = i;
        }
        f: for(int i = 0; i < skill_trees.length; ++i){
            String sk = skill_trees[i];
            int lastIdx = 0;
            for(int j = 0; j < sk.length(); ++j){
                if(skillIdx[sk.charAt(j)] != -1){
                    if(skillIdx[sk.charAt(j)] == lastIdx){
                        lastIdx++;
                    }else{
                        continue f;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
public class 스킬트리 {
	public static void main(String[] args) throws Exception{
		
	}
}
