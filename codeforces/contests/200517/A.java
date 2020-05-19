package A;

import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(a <= b) {
				answer.append(b).append('\n');
				continue;
			}
			a -= b;
			if(d >= c) {
				answer.append("-1\n");
				continue;
			}
			int div = c-d;
			long ans = a/div;
			if(a%div!=0) {
				ans++;
			}
			ans = (long)b + ans * (long)c;
			answer.append(ans).append('\n');
		}
		System.out.println(answer);
	}
}
