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
			int c= Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x+b-a<=x2 && x+b-a >=x1 && y+d-c >=y1 && y+d-c <=y2) {
				boolean check = true;
				if(a>0 && (b==0 || x2==x) && x==x1) {
					check = false;
				}
				if(b>0 && (a==0 || x1 == x) && x==x2) check = false;
				if(c >0 && (d==0 || y2==y) && y==y1) check = false;
				if(d > 0 && (c==0 || y1==y) && y==y2) check = false;
				if(check) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
