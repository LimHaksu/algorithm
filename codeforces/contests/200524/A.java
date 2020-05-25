package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int len;
			if(a < b) {
				len = a*2;
				if(len < b) {
					len = b;
				}
			}else {
				len = b*2;
				if(len < a) {
					len = a;
				}
			}
			ans.append(len*len).append('\n');
		}
		System.out.println(ans);
	}
}
