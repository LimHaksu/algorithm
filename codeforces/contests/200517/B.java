package B;

import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			String s = br.readLine();
			int[] count1 = new int[4];
			Deque<Integer> dq = new LinkedList<Integer>();
			boolean find1 = false;
			int len1 = Integer.MAX_VALUE;
			for(int i = 0; i < s.length(); ++i) {
				int num = s.charAt(i)-'0';
				count1[num]++;
				dq.addLast(num);
				while(!dq.isEmpty() && count1[dq.peekFirst()] > 1) {
					count1[dq.removeFirst()]--;
				}
				if(count1[1] >=1 && count1[2] >= 1 && count1[3] >= 1) {
					find1 = true;
					if(len1 > dq.size()) {
						len1 = dq.size();
					}
				}
			}
			int[] count2 = new int[4];
			boolean find2 = false;
			int len2 = Integer.MAX_VALUE;
			Deque<Integer> dq2 = new LinkedList<Integer>();
			for(int i = s.length()-1; i >= 0; --i) {
				int num = s.charAt(i)-'0';
				count2[num]++;
				dq2.addLast(num);
				while(!dq2.isEmpty() && count2[dq2.peekFirst()] > 1) {
					count2[dq2.removeFirst()]--;
				}
				if(count2[1] >=1 && count2[2] >= 1 && count2[3] >= 1) {
					find2 =true;
					if(len2 > dq2.size()) {
						len2 = dq2.size();
					}
				}
			}
			if(find1 && find2) {
				int ans = Math.min(len1, len2);
				answer.append(ans).append('\n');
			}else if(find1) {
				System.out.println(len1);
			}else if(find2) {
				System.out.println(len2);
			}else {
				answer.append("0\n");
			}
		}
		System.out.println(answer);
	}
}
