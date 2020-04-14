package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			StringBuilder sb= new StringBuilder();
			char[] arr = new char[b];
			for(int i = 0; i < b; ++i) {
				arr[i] = (char)('a'+i);
			}
			for(int i = 0; i < n; ++i) {
				sb.append(arr[i%b]);
			}
			ans.append(sb).append('\n');
		}
		System.out.println(ans);
	}
}
