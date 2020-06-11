package A;

import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int answer = 0;
			if(a>b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if(b >= a*2) {
				answer = a;
			}else {
				int c = (b-a);
				b -= 2*c;
				a -= c;
				int count = (a / 3);
				a -= count * 3;
				b -= count * 3;
				count *= 2;
				while(b>=2 && a >=1) {
					count++;
					b-=2;
					a-=1;
				}
				count += c;
				answer = count;
			}
			ans.append(answer).append('\n');
		}
		System.out.print(ans);
	}
}
