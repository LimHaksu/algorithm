import java.io.*;
import java.util.*;

public class n1372A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new  StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; ++i) {
				sb.append("1 ");
			}
			answer.append(sb).append('\n');
		}
		System.out.println(answer);
	}
}
