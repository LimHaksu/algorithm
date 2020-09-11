import java.io.*;
import java.util.*;

class IdOp{
	String id, op;
	IdOp(String id, String op){
		this.id = id;
		this.op = op;
	}
}

class Solution {
	
    public String[] solution(String[] record) {
        Map<String, String> idNicknameMap = new HashMap<String, String>();
        List<IdOp> idOpList = new ArrayList<>();
        
        for(int i = 0; i < record.length; ++i) {
        	String[] splited = record[i].split(" ");
        	String op = splited[0];
        	String uid = splited[1];
        	String nickname = "";
        	if(op.equals("Enter") || op.equals("Change")) {
        		nickname = splited[2];
        	}
        	switch(op) {
        	case "Enter":
        		idNicknameMap.put(uid, nickname);
        		idOpList.add(new IdOp(uid, op));
        		break;
        	case "Change":
        		idNicknameMap.replace(uid,  nickname);
        		break;
        	case "Leave":
        		idOpList.add(new IdOp(uid, op));
        		break;
        	}
        	
        }
        List<String> tempAns = new ArrayList<>();
        for(int i = 0; i < idOpList.size(); ++i) {
        	String nickname = idNicknameMap.get(idOpList.get(i).id);
        	String op = idOpList.get(i).op;
        	switch(op) {
        	case "Enter":
        		tempAns.add(nickname+"님이 들어왔습니다.");
        		break;
        	case "Leave":
        		tempAns.add(nickname+"님이 나갔습니다.");
        		break;
       		default:
       			break;
        	}
        }
        String[] answer = new String[tempAns.size()];
        for(int i = 0; i < tempAns.size(); ++i) {
        	answer[i] = tempAns.get(i);
        }
        return answer;
    }
}

public class 오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(record)));
	}
}
