package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		f: for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long multi = 0;
			if(a>b) {
				if(a%b!=0) {
					ans.append("-1\n");
					continue;
				}
				multi = a/b;
			}else {
				if(b%a!=0) {
					ans.append("-1\n");
					continue;
				}
				multi = b/a;
			}
			long count = 0;
			if(multi==1) {
				ans.append("0\n");
				continue;
			}
			if(multi%2==1) {
				ans.append("-1\n");
				continue;
			}
			while(multi>1) {
				count++;
				multi /= 2;
				if(multi!=1 && multi%2==1) {
					ans.append("-1\n");
					continue f;
				}
			}
			long count2 = 0;
			while(count>0) {
				if(count>=3) {
					count-=3;
					count2++;
				}else if(count>=2) {
					count-=2;
					count2++;
				}else {
					count--;
					count2++;
				}
			}
			ans.append(count2).append('\n');
		}
		System.out.println(ans);
	}
}
