package codeforces;

import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < t; ++tc) {
			st = new StringTokenizer(br.readLine());
			long n = Integer.parseInt(st.nextToken());
			long k = Integer.parseInt(st.nextToken());
			if(n%2==0) {
				if(k%2==0 && n >= k*k) {
					System.out.printf("YES\n");
				}else {
					System.out.printf("NO\n");
				}
			}else {
				if(k%2==1 && n >= k*k) {
					System.out.printf("YES\n");
				}else {
					System.out.printf("NO\n");
				}
			}
			
		}
	}
}
