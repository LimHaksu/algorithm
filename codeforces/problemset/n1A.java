package codeforces;
import java.util.*;
import java.io.*;
public class n1A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		long w = n/a;
		if(n%a!=0) w++;
		long h = m/a;
		if(m%a!=0) h++;
		System.out.println(w*h);
	}
}
