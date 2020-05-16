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
			long a1 = Long.parseLong(st.nextToken());
			long k = Long.parseLong(st.nextToken());
			while(--k>0) {
				long min = Long.MAX_VALUE;
				long max = Long.MIN_VALUE;
				long ta = a1;
				while(ta>0) {
					long tat = ta%10;
					if(tat > max) {
						max = tat;
					}
					if(tat < min) {
						min = tat;
					}
					ta/=10;
				}
				if(min==0) {
					break;
				}
				a1 += min*max;
			}
//			System.out.println(a1);
			ans.append(a1).append('\n');
		}
		System.out.println(ans);
	}
}
