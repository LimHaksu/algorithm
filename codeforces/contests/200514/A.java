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
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==1) {
				answer.append("0\n");
			}else if(n==2) {
				answer.append(m).append('\n');
			}else {
				answer.append(2*m).append('\n');
			}
		}
		System.out.println(answer);
	}
}
