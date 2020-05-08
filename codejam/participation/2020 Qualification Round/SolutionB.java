package codejam;

import java.util.*;
import java.io.*;
public class SolutionB {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				int num = c-'0';
				for(int j = 0; j < num; ++j) {
					sb.append('(');
				}
				sb.append(c);
				for(int j = 0; j < num ; ++j) {
					sb.append(')');
				}
			}
			Stack<Character> st = new Stack<>();
			for(int i = 0; i < sb.length(); ++i) {
				if(sb.charAt(i) == '(') {
					if(!st.isEmpty() && st.peek()==')') {
						st.pop();
					}else {
						st.push('(');
					}
				}else {
					st.push(sb.charAt(i));
				}
			}
			sb = new StringBuilder();
			for(char c : st) {
				sb.append(c);
			}
			ans.append("Case #"+tc+": "+sb+"\n");
		}
		System.out.println(ans);
	}
}
