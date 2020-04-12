package B;

import java.io.*;
import java.util.*;
public class B{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ArrayList<Integer> a = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			for(int i = 0; i < n; ++i) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(a, Collections.reverseOrder());
			int i = 1;
			for(; i <= n; ++i) {
				sum += a.get(i-1);
				if(sum/i < x) {
					break;
				}
			}
			answer.append(i-1).append('\n');
		}
		System.out.println(answer);
	}
}
