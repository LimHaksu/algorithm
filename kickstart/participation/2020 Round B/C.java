package C;

import java.io.*;
import java.util.*;
public class C {
	static int len = 1000_000_000;
	static int[] index = new int[128];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		index['N'] = 0;
		index['E'] = 1;
		index['S'] = 2;
		index['W'] = 3;
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			String s = br.readLine();
			Long[] nesw = new Long[4];
			for(int i = 0; i < 4; ++i) {
				nesw[i] = 0L;
			}
			Stack<Long> cn = new Stack<Long>();
			cn.push(1L);
			for(int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				if(c>='2' && c<='9') {
					Long top = (cn.peek() * (c-'0')) % len;
					cn.push(top);
					++i;
				}else if(c == ')'){
					cn.pop();
				}else {
					nesw[index[c]] = (nesw[index[c]] + cn.peek()) % len;
				}
			}
			int cr = 1;
			int cc = 1;
			cr += (nesw[2] - nesw[0])%len;
			if(cr > len) {
				cr -= len;
			}
			if(cr < 1) {
				cr += len;
			}
			cc += (nesw[1] - nesw[3])%len;
			if(cc > len) {
				cc -= len;
			}
			if(cc < 1) {
				cc += len;
			}
			answer.append("Case #"+tc+": "+cc+" "+cr+"\n");
		}
		System.out.println(answer);
	}
}
