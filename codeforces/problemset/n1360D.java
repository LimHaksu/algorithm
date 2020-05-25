package D;

import java.io.*;
import java.util.*;
public class n1360D {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int size = (int)Math.sqrt(n)+1;
			if(k>=n) {
				ans.append("1\n");
				continue;
			}
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i = 1; i <= size; ++i) {
				if(n%i==0) {
					arr.add(i);
					arr.add(n/i);
				}
			}
			Collections.sort(arr);
			for(int i = arr.size()-1; i >= 0; --i) {
				if(arr.get(i) <= k) {
					ans.append(n/arr.get(i)).append('\n');
					break;
				}
			}
		}
		System.out.print(ans);
	}
}
