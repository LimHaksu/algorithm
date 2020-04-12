package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] p = new int[n];
			int[] c = new int[n];
			StringTokenizer st;
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				p[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean check = true;
			if(p[0] < c[0]) {
				sb.append("NO\n");
				continue;
			}
			int maxc = c[0];
			int maxp = p[0];
			for(int i = 1; i < n; ++i) {
				int diffp = p[i]-p[i-1];
				int diffc = c[i]-c[i-1];
				if(diffp < diffc) {
					check = false;
					break;
				}
				if(p[i] < c[i]) {
					check = false;
					break;
				}
				if(c[i] < maxc || p[i] < maxp) {
					check = false;
					break;
				}
				maxc = c[i];
				maxp = p[i];
			}
			if(check) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
