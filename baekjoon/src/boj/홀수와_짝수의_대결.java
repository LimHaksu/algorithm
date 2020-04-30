package boj;
import java.io.*;
import java.util.*;
public class 홀수와_짝수의_대결 {
	static List<Integer> prime;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[500000001];
		prime = new ArrayList<>(); 
		for(int i = 2; i < isPrime.length; ++i) {
			if(!isPrime[i]) {
				prime.add(i);
				for(int j = i; j < isPrime.length; j += i) {
					isPrime[j] = true;
				}
			}
		}
		System.out.println(prime.size());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			sb.append(isOdd(n)?"E\n":"O\n");
		}
		System.out.println(sb);
	}
	static boolean isOdd(int n) {
		int idx = 0;
		int count = 0;
		while(n>1) {
			int p = prime.get(idx);
			while(n%p==0) {
				System.out.println(n+", "+p);
				n /= p;
				count++;
			}
			idx++;
		}
		System.out.println("count: "+count);
		return count%2==0;
	}
}
