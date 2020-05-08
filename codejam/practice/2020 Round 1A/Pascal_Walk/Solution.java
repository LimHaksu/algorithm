package B;

import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		// 파스칼 삼각형 만들기
		int[][] arr = new int[32][32];
		for(int i = 0; i < 32; ++i) {
			arr[i][0] = 1;
			for(int j = 1; j < i; ++j) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
			arr[i][i] = 1;
		}
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			int nn = n - 32;
			int sum = 0;
			int num = 1;
			int idx = 1;
			boolean left = true;
			while(nn>0) {
				if(nn%2==1) {
					sum += num;
					if(left) {
						for(int i = 1; i <= idx; ++i) {
							sb.append(""+idx+" "+i+"\n");
						}
						left = false;
					}else {
						for(int i = idx; i >= 1; --i) {
							sb.append(""+idx+" "+i+"\n");
						}
						left = true;
					}
				}else {
					sum += 1;
					if(left) {
						sb.append(""+idx+" "+1+"\n");
					}else {
						sb.append(""+idx+" "+idx+"\n");
					}
				}
				num *= 2;
				nn /= 2;
				idx++;
			}
			while(n>sum) {
				if(left) {
					sb.append(""+idx+" "+1+"\n");					
				}else {
					sb.append(""+idx+" "+idx+"\n");					
				}
				idx++;
				sum++;
			}
			ans.append("Case #"+tc+":\n").append(sb);
		}
		System.out.println(ans);
	}
}