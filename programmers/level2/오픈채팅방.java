import java.util.*;
class Solution {
	class Log{
		String id;
		String log;
		Log(String id, String log){
			this.id = id;
			this.log = log;
		}
	}
    public String[] solution(String[] record) {
        HashMap<String, String> idNick = new HashMap<>();
        List<Log> logs = new ArrayList<>();
        for(int i = 0; i < record.length; ++i) {
        	String[] s = record[i].split(" ");
        	switch(s[0]) {
        	case "Enter":
        		idNick.put(s[1], s[2]);
        		logs.add(new Log(s[1], s[0]));
        		break;
        	case "Leave":
        		logs.add(new Log(s[1], s[0]));
        		break;
        	case "Change":
        		idNick.put(s[1], s[2]);
        		break;
        	}
        }
        String[] answer = new String[logs.size()];
        for(int i = 0; i < answer.length; ++i) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(idNick.get(logs.get(i).id));
        	sb.append("님이 ");
        	if(logs.get(i).log.equals("Enter")) {
        		sb.append("들어왔습니다.");
        	}else {
        		sb.append("나갔습니다.");
        	}
        	answer[i] = sb.toString();
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
