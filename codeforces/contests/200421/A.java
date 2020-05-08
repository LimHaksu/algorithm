package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int num = 4;
			while(true) {
				if(n%(num-1)==0) {
					ans.append(n/(num-1)).append('\n');
					break;
				}
				num *= 2;
			}
		}
		System.out.println(ans);
	}
}
