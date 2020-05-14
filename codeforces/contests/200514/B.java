package B;

import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new  StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				max += arr[i];
			}
			int[] arr2 = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < k ;++i) {
				Arrays.sort(arr);
				Arrays.sort(arr2);
				int temp = arr[0];
				arr[0] = arr2[n-1];
				arr2[n-1] = temp;
				int sum = 0;
				for(int j = 0; j < n; ++j) {
					sum += arr[j];
				}
				if(sum > max) {
					max = sum;
				}
			}
			answer.append(max).append('\n');
		}
		System.out.println(answer);
	}
}
