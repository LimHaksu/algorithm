package B;

import java.io.*;
import java.util.*;
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			TreeSet<Integer> set1 = new TreeSet<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
			});
			int max = 0;
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				set1.add(arr[i]);
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			boolean find = false;
			for(int k = 1; k <= max*2; ++k) {
				TreeSet<Integer> set2 = new TreeSet<>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o1, o2);
					}
				});
				for(int i = 0; i < n; ++i) {
					set2.add(arr[i]^k);
				}
				TreeSet<Integer> set1temp = new TreeSet<>(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.compare(o1, o2);
					}
				});
				for(int num : set1) {
					set1temp.add(num);
				}
				boolean check = true;
				while(!set2.isEmpty()) {
					int s1 = set1temp.pollFirst();
					int s2 = set2.pollFirst();
					if(s1 != s2) {
						check = false;
						break;
					}
				}
				if(check) {
					ans.append(k).append('\n');
					find = true;
					break;
				}
			}
			if(!find) {
				ans.append("-1\n");
			}
		}
		System.out.println(ans);
	}
}
