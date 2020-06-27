import java.io.*;
public class n1370A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			if(n%2==0) {
				answer.append(n/2).append('\n');
			}else {
				answer.append((n-1)/2).append('\n');
			}
		}
		System.out.println(answer);
	}
}
