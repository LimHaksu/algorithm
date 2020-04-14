package C;

import java.io.*;
import java.util.*;
public class C{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
			for(int i = 0; i < n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
				if(map.containsKey(a[i])) {
					map.put(a[i],map.get(a[i])+1);
				}else {
					map.put(a[i],1);
				}
			}
			int max = 0;
			int countOne = 0;
			int countTwo = 0;
			for(int num : map.values()) {
				if(max < num) {
					max = num;
				}
				if(num>1) {
					countTwo++;
				}
				if(num==1) {
					countOne++;
				}
			}
			int answer = -1;
			int countTotal = countOne + countTwo;
			if(countTotal == 1) {
				if(max >= 2) {
					ans.append("1\n");
				}else {
					ans.append("0\n");
				}
				continue;
			}
			int temp = countTotal-1; // max 제외
			if(max >= temp+2) {
				answer = temp+1;
			}else if(max == temp) {
				answer = temp;
			}else {
				answer = Math.min(max, temp);
			}
			ans.append(answer).append('\n');
		}
		System.out.println(ans);
	}
}