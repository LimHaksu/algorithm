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
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int forOne = n/k;
			if(forOne >= m) {
				ans.append(m).append('\n');
			}else {
				int win = forOne;
				m -= win;
				int second = 0;
				while(m > 0) {
					second++;
					m -= (k-1);
				}
				ans.append(win-second).append('\n');
			}
		}
		System.out.println(ans);
	}
}
