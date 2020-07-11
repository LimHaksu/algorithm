import java.io.*;
import java.util.*;
public class n1375A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < n; ++i) {
				if(i%2==1) {
					if(arr[i] > 0) {
						arr[i] *= -1;
					}
				}else {
					if(arr[i] < 0) {
						arr[i] *= -1;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; ++i) {
				sb.append(arr[i]).append(' ');
			}
			answer.append(sb).append('\n');
		}
		System.out.println(answer);
	}
}
