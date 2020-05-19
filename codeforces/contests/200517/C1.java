package C;

import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int repeat = (n/2-1);
			double ans = 1;
			double sum = 0;
			double angle = Math.PI/(double)n;
			double added = angle;
			for(int i = 0; i < repeat; ++i) {
				sum += Math.cos(added);
				added += angle;
			}
			answer.append(ans+sum*2).append('\n');
		}
		System.out.println(answer);
	}
}
