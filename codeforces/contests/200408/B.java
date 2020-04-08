package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int[] brr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				brr[i] = Integer.parseInt(st.nextToken());
			}
			boolean minus = false;
			boolean plus = false;
			boolean check = true;
			f: for(int i = 0;i < n; ++i) {
				if(arr[i] < brr[i]) {
					if(!plus) {
						check = false;
						break f;
					}
				}else if(arr[i] > brr[i]){
					if(!minus) {
						check = false;
						break f;
					}
				}
				if(arr[i] == -1) {
					minus = true;
				}else if(arr[i] == 1) {
					plus = true;
				}
			}
			if(check) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
