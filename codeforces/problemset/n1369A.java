import java.io.*;
import java.util.*;
public class n1369A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t;++tc) {
			int n = Integer.parseInt(br.readLine());
			answer.append(n%4==0?"YES\n":"NO\n");
		}
		System.out.println(answer);
	}
}
