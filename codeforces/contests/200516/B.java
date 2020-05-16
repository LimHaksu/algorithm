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
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int count = 0;
			int gSize = arr[0];
			int gCount = 1;
			for(int i = 1; i < arr.length; ++i) {
				if(gCount == gSize) {
					count++;
					gSize = arr[i];
					gCount = 1;
				}else {
					gCount++;
					gSize = arr[i];
				}
			}
			if(gCount == gSize) {
				count++;
			}
			ans.append(count).append('\n');
		}
		System.out.println(ans);
	}
}
