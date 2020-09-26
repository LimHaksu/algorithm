package A1;

import java.io.*;
import java.util.*;

class Solution {
	public int solution(String[] lines) {
		int answer = 0;
		int[][] time = new int[lines.length][2];
		for (int i = 0; i < lines.length; ++i) {
			String end = lines[i].split(" ")[1];
			int endTime = strToInt(end);
			String minusTime = lines[i].split(" ")[2].split("s")[0];
			int startTime = endTime - strToInt2(minusTime) + 1;
			time[i][0] = startTime;
			time[i][1] = endTime;
		}
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});
		for (int i = 0; i < time.length; ++i) {
			int count = 1;
			for(int j = i+1; j < time.length; ++j) {
				if(time[i][1]+1000 > time[j][0]) {
					count++;
				}
			}
			if (count > answer) {
				answer = count;
			}
		}
		return answer;
	}

	int strToInt(String time) {
		String[] hms = time.split(":");
		int hour = Integer.parseInt(hms[0]);
		int minute = Integer.parseInt(hms[1]);
		String[] ss = hms[2].split("\\.");
		int second1 = Integer.parseInt(ss[0]);
		int second2 = Integer.parseInt(ss[1]);
		return (hour * 60 * 60 + minute * 60 + second1) * 1000 + second2;
	}

	int strToInt2(String second) {
		String[] seconds = second.split("\\.");
		if (seconds.length > 1) {
			int part2 = (int)Double.parseDouble(seconds[1]);
			return Integer.parseInt(seconds[0]) * 1000 + part2;
		} else {
			return Integer.parseInt(seconds[0]) * 1000;
		}
	}
}

public class 추석트래픽 {
	public static void main(String[] args) {
		String[] inputs = {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
//		String[] inputs = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		Solution sol = new Solution();
		System.out.println(sol.solution(inputs));
	}
}
