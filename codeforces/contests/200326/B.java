package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int num = 1;
			int sum = 0;
			while(k-sum>0) {
				sum += num;
				num++;
			}
			num--;
			sum -= num;
			int idx1 = num+1;
			int idx2 = k-sum;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; ++i) {
				if(i==n-idx1 || i==n-idx2) {
					sb.append('b');
				}else {
					sb.append('a');
				}
			}
			ans.append(sb).append('\n');
		}
		System.out.println(ans);
	}
}
