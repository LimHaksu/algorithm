import java.io.*;
import java.util.*;
public class n1368A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			int count = 0;
			boolean flag = true;
			while(a <= n && b <= n) {
				if(flag) {
					a += b;
				}else {
					b += a;
				}
				count++;
				flag = !flag;
			}
			answer.append(count).append('\n');
		}
		System.out.println(answer);
	}
}
