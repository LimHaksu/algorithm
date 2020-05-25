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
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int countOdd = 0;
			int countEven = 0;
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i]%2==0) {
					countEven++;
				}else {
					countOdd++;
				}
			}
			Arrays.sort(arr);
			int countDiffOne = 0;
			for(int i = 0; i < n-1; ++i) {
				if(arr[i+1]-arr[i]==1) {
					countDiffOne++;
				}
			}
			if(countOdd % 2 == 0 && countEven % 2 == 0) {
				ans.append("YES\n");
			}else {
				if((countOdd % 2 == 0 && countEven % 2 == 1)
						|| (countOdd % 2 == 1 && countEven % 2 == 0)) {
					ans.append("NO\n");
				}else {
					if(countDiffOne > 0) {
						ans.append("YES\n");
					}else {
						ans.append("NO\n");
					}
				}
			}
		}
		System.out.println(ans);
	}
}
