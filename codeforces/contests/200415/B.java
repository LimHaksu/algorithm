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
			int x = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			while(n-->0) {
				if(x>20) {
					x = x/2+10;
				}else {
					break;
				}
			}
			while(m-->0) {
				x -= 10;
			}
			if(x <= 0) {
				ans.append("YES\n");
			}else {
				ans.append("NO\n");
			}
		}
		System.out.println(ans);
	}
}
