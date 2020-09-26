import java.util.*;

class Solution {
	class Node implements Comparable<Node> {
		String name;
		int playTime;
		int idx;

		Node(String name, int playTime, int idx) {
			this.name = name;
			this.playTime = playTime;
			this.idx = idx;
		}

		@Override
		public int compareTo(Node o) {
			if (this.playTime > o.playTime) {
				return -1;
			} else if (this.playTime < o.playTime) {
				return 1;
			}
			return Integer.compare(this.idx, o.idx);
		}
	}

	public String solution(String m, String[] musicinfos) {
		// 시작시각, 끝 시각, 제목, 악보정보
		// C# -> H, D# -> I, F# -> J, G# -> K, A# -> L
		m = m.replaceAll("D#", "I");
		m = m.replaceAll("C#", "H");
		m = m.replaceAll("F#", "J");
		m = m.replaceAll("G#", "K");
		m = m.replaceAll("A#", "L");
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < musicinfos.length; ++i) {
			String[] info = musicinfos[i].split(",");
			int startTime = timeToMinutes(info[0]);
			int endTime = timeToMinutes(info[1]);
			int playTime = endTime - startTime;
			// C# -> H, D# -> I, F# -> J, G# -> K, A# -> L
			info[3] = info[3].replaceAll("C#", "H");
			info[3] = info[3].replaceAll("D#", "I");
			info[3] = info[3].replaceAll("F#", "J");
			info[3] = info[3].replaceAll("G#", "K");
			info[3] = info[3].replaceAll("A#", "L");
			if (playTime < info[3].length()) {
				info[3] = info[3].substring(0, playTime);
			} else if (playTime > info[3].length()) {
				StringBuilder sb = new StringBuilder();
				while (sb.length() < playTime) {
					sb.append(info[3]);
				}
				info[3] = sb.substring(0, playTime);
			}
			if (info[3].contains(m)) {
				pq.add(new Node(info[2], playTime, i));
			}
		}
		if(pq.size()>0) {
			return pq.poll().name;
		}
		return "(None)";
	}

	int timeToMinutes(String time) {
		String[] hm = time.split(":");
		return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
	}
}
public class 방금그곡 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(sol.solution(m, musicinfos));
	}
}
