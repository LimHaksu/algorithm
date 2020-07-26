import java.io.*;
import java.util.*;
public class n1380A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		f: for(int tc= 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] p = new int[n];
			for(int i = 0; i < n; ++i) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i < n-1; ++i) {
				if(p[i] > p[i-1] && p[i] > p[i+1]) {
					answer.append("YES\n"+i+" "+(i+1)+" "+(i+2)+"\n");
					continue f;
				}
			}
			answer.append("NO\n");
		}
		System.out.println(answer);
	}
}
