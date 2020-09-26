import java.util.*;

class Solution {
	class Node implements Comparable<Node> {
		String head;
		String headOrigin;
		String numberOrigin;
		int number;
		String tail;

		Node(String file) {
			int idx = 0;
			StringBuilder sb = new StringBuilder();
			while (file.charAt(idx) < '0' || file.charAt(idx) > '9') {
				sb.append(file.charAt(idx));
				idx++;
			}
			headOrigin = sb.toString();
			head = headOrigin.toLowerCase();
			sb = new StringBuilder();
			while (idx < file.length() && file.charAt(idx) >= '0' && file.charAt(idx) <= '9') {
				sb.append(file.charAt(idx));
				idx++;
			}
			numberOrigin = sb.toString();
			number = Integer.parseInt(numberOrigin);
			if(idx < file.length()) {
				tail = file.substring(idx, file.length());
			}else {
				tail = "";
			}
			System.out.println(head+", "+number+", "+tail);
		}

		public String toString() {
			return this.headOrigin + this.numberOrigin + this.tail;
		}

		public int compareTo(Node o) {
			if (this.head.compareTo(o.head) < 0) {
				return -1;
			} else if (this.head.compareTo(o.head) > 0) {
				return 1;
			}
			return Integer.compare(this.number, o.number);
		}
	}

	public String[] solution(String[] files) {
		List<Node> arr = new ArrayList<>();
		for (int i = 0; i < files.length; ++i) {
			arr.add(new Node(files[i]));
		}
		Collections.sort(arr);
		String[] answer = new String[files.length];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = arr.get(i).toString();
		}
		return answer;
	}
}

public class 파일명_정렬 {
	public static void main(String[] args) {
		String[] files = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(files)));
	}
}
