package C;

import java.io.*;
import java.util.*;
public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			boolean find = false;
			StringBuilder[] sb = new StringBuilder[2];
			sb[0] = new StringBuilder();
			sb[1] = new StringBuilder();
			for(int i = 0; i < n; ++i) {
				if(find) {
					sb[0].append('0');
					sb[1].append(x.charAt(i));
				}else {
					if(x.charAt(i)=='2') {
						sb[0].append('1');
						sb[1].append('1');
					}else if(x.charAt(i)=='0') {
						sb[0].append('0');
						sb[1].append('0');
					}else {
						sb[0].append('1');
						sb[1].append('0');
						find = true;
					}
				}
			}
			ans.append(sb[0]).append('\n').append(sb[1]).append('\n');
		}
		System.out.println(ans);
	}
}
