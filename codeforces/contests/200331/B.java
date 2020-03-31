package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean[] pCheck = new boolean[1001];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for(int i = 2; i <= 1000; ++i) {
			if(!pCheck[i]) {
				prime.add(i);
				for(int j = i; j <= 1000; j+=i) {
					pCheck[j] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int m = 1;
			int[] ans = new int[n];
			boolean[] check = new boolean[n];
			for(int div : prime) {
				boolean exist = false;
				for(int i = 0; i < n; ++i) {
					if(arr[i]%div==0) {
						if(!check[i]) {
							check[i] = true;
							exist = true;
							ans[i] = m;
						}
					}
				}
				if(exist) {
					m++;
				}
			}
			sb.append(m-1).append('\n');
			for(int i = 0; i < n; ++i) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static int gcd(int a, int b) {
		while(b > 0) {
			int temp = b;
			b  = a/b;
			a = temp;
		}
		return a;
	}
}
