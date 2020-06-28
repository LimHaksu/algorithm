import java.io.*;
import java.util.*;
public class n1373A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			long first = -1;
			long second = -1;
			if(a < c) {
				first = 1;
			}
			if(a * b > c) {
				second = b;
			}
			answer.append(first).append(' ').append(second).append('\n');
		}
		System.out.println(answer);
	}
}
