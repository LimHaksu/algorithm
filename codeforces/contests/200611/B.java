package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int l = x;
			int r = x;
			for(int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine());
				int ll = Integer.parseInt(st.nextToken());
				int rr = Integer.parseInt(st.nextToken());
				if(l <= rr && ll < l) {
					l = ll;
				}
				if(ll <= r && r < rr) {
					r = rr;
				}
			}
			ans.append(r-l+1).append('\n');
		}
		System.out.println(ans);
	}
}
