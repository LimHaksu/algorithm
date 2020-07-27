import java.io.*;
import java.util.*;

public class n1382A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; ++i) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			boolean find = false;
			StringBuilder sb = new  StringBuilder();
			f: for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(a[i] == b[j]) {
						find = true;
						sb.append("YES\n1 "+a[i]+"\n");
						break f;
					}
				}
			}
			if(!find) {
				sb.append("NO\n");
			}
			answer.append(sb);
		}
		System.out.println(answer);
	}
}