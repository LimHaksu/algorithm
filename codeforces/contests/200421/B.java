package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			if(n%4!=0) {
				ans.append("NO\n");
			}else {
				ans.append("YES\n");
				int[] arr1 = new int[n/2];
				int sum = 0;
				for(int i = 0; i < arr1.length; ++i) {
					arr1[i] = (i+1)*2;
					sum += arr1[i];
				}
				int[] arr2 = new int[n/2];
				int sum2 = 0;
				for(int i = 0; i < arr2.length-1; ++i) {
					arr2[i] = (i+1)*2-1;
					sum2 += arr2[i];
				}
				arr2[arr2.length-1] = sum-sum2;
				for(int i = 0; i < arr1.length; ++i) {
					ans.append(arr1[i]).append(' ');
				}
				for(int i = 0; i < arr2.length; ++i) {
					ans.append(arr2[i]).append(' ');
				}
				ans.append('\n');
			}
		}
		System.out.println(ans);
	}
}
