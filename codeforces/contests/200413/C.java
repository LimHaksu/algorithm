package C;
import java.io.*;
import java.util.*;

public class C2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new  StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int max = a[0];
			int[] diff = new int[n];
			for(int i = 1; i < n; ++i) {
				diff[i] = max-a[i];
				if(max < a[i]) {
					max = a[i];
				}
			}
			int diffMax = 0;
			for(int i = 0; i < n; ++i) {
				if(diff[i] > diffMax) {
					diffMax = diff[i];
				}
			}
			long sum = 0;
			long time = 1;
			long num = 1;
			while(sum < diffMax) {
				sum += num;
				time++;
				num *= 2;
			}
			ans.append(--time).append('\n');
		}
		System.out.println(ans);
	}
}
