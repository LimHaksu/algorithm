import java.io.*;
import java.util.*;
public class n1374A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int a = (n-y)/x;
			answer.append(y+a*x).append('\n');
		}
		System.out.println(answer);
	}
}
