import java.util.*;

class Solution {
	public int[] solution(String msg) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 1; i <= 26; ++i) {
			map.put(String.valueOf((char) ('A' + i - 1)), i);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < msg.length(); ++i) {
			StringBuilder sb = new StringBuilder();
			sb.append(msg.charAt(i));
			while (map.containsKey(sb.toString())) {
				++i;
				if (i == msg.length()) {
					break;
				}
				sb.append(msg.charAt(i));
			}
			if(i == msg.length()) {
				arr.add(map.get(sb.toString()));
			}else {
				arr.add(map.get(sb.substring(0, sb.length() - 1)));
			}
			i--;
			map.put(sb.toString(), map.size() + 1);
		}
		int[] answer = new int[arr.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}

public class 압축 {
	public static void main(String[] args) {
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(msg)));
	}
}
