package A;

import java.io.*;
import java.util.*;
public class A{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			int oddCount = 0;
			int evenCount = 0;
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] % 2 == 1) {
					oddCount++;
				}else {
					evenCount++;
				}
			}
			int count = 0;
			if(oddCount == 0) {
				ans.append("NO\n");
				continue;
			}
			oddCount--;
			count++;
			while(oddCount >= 2 && count <= x-2) {
				count += 2;
				oddCount -= 2;
			}
			if(count == x) {
				ans.append("YES\n");
				continue;
			}
			while(evenCount >= 1 && count < x) {
				count++;
				evenCount--;
			}
			if(count == x) {
				ans.append("YES\n");
			}else {
				ans.append("NO\n");
			}
		}
		System.out.print(ans);
	}
}
