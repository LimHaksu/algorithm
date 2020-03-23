package codeforces;


import java.util.*;
import java.io.*;
public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			HashSet<Integer> set = new HashSet<Integer>();
			int unSelect = -1;
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				ArrayList<Integer> temp = new ArrayList<Integer>();
				boolean checkSelect = false;
				for(int j = 0; j < k; ++j) {
					int num = Integer.parseInt(st.nextToken());
					if(!set.contains(num) && !checkSelect) {
						checkSelect = true;
						set.add(num);
					}
					temp.add(num);
				}
				list.add(temp);
				if(!checkSelect) {
					unSelect = i+1;
				}
			}
			int unSelectKing = -1;
			for(int i = 1; i <= n; ++i) {
				if(!set.contains(i)) {
					unSelectKing = i;
					break;
				}
			}
			if(unSelect != -1 && unSelectKing != -1) {
				sb.append("IMPROVE\n").append(unSelect).append(' ').append(unSelectKing).append('\n');
			}else {
				sb.append("OPTIMAL\n");
			}
		}
		System.out.println(sb);
	}
}
