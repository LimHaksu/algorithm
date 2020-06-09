package B;

import java.io.*;
import java.util.*;
public class n1365B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean sortedCheck = true;
			for(int i = 0; i < n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
				if(i>0 && a[i] < a[i-1]) {
					sortedCheck = false;
				}
			}
			st = new StringTokenizer(br.readLine());
			int[] b = new int[n];
			int[] count = new int[2];
			for(int i = 0; i < n; ++i) {
				b[i] = Integer.parseInt(st.nextToken());
				count[b[i]]++;
			}
			if(sortedCheck || (count[0]>0 && count[1]>0)) {
				ans.append("YES\n");
			}else {
				ans.append("NO\n");
			}
		}
		System.out.print(ans);
	}
}
