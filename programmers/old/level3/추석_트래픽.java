import java.util.*;

class Solution {
	class Node{
		int start;
		int end;
		Node(String time, String duration){
			int d = (int)(Double.parseDouble(duration.split("s")[0])*1000);
			int end = timeToInt(time);
			int start = end-d+1;
			this.start = start;
			this.end = end;
		}
	}
	int timeToInt(String time) {
		int ret = 0;
		String[] hms = time.split(":");
		ret += Integer.parseInt(hms[0])*3600000;
		ret += Integer.parseInt(hms[1])*60000;
		ret += (int)(Double.parseDouble(hms[2])*1000);
		return ret;
	}
	public int solution(String[] lines) {
		int answer = 0;
		Node[] arr = new Node[lines.length];
		for(int i = 0; i < lines.length; ++i) {
			String[] splited = lines[i].split(" ");
			arr[i] = new Node(splited[1], splited[2]);
		}
		Arrays.sort(arr, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.end,  o2.end);
			}
		});
		for(int i = 0; i < arr.length; ++i) {
			int count = 1;
			Node current = arr[i];
			for(int j = i+1; j < arr.length; ++j) {
				if(arr[j].start < current.end + 1000) {
					count++;
				}
			}
			if(count > answer) {
				answer = count;
			}
		}
		return answer;
	}
}

public class 추석_트래픽 {
	public static void main(String[] args) {
		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		Solution sol = new Solution();
		System.out.println(sol.solution(lines));
	}
}
