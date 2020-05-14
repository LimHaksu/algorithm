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
			long b = 3;
			long num = 1;
			int size = n/2;
			long sum = 0;
			for(int i = 0; i < size; ++i) {
				sum += (b*4-4)*num;
				b += 2;
				num++;
			}
			answer.append(sum).append('\n');
		}
		System.out.println(answer);
	}
}
