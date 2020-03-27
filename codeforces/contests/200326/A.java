package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a%b==0) {
				sb.append("0\n");
			}else {
				sb.append((a/b+1)*b-a+"\n");
			}			
		}
		System.out.println(sb);
	}
}
