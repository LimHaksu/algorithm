import java.io.*;
import java.util.*;
public class n1363A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new  StringBuilder();
		for(int tc= 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int odd = 0, even = 0;
			st = new  StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp % 2 == 0) {
					even++;
				}else {
					odd++;
				}
			}
			int oddCount = 1;
			boolean find = false;
			while(oddCount <= x) {
				if(oddCount <= odd && x-oddCount <= even) {
					find = true;
					break;
				}
				oddCount += 2;
			}
			if(find) {
				answer.append("YES\n");
			}else {
				answer.append("NO\n");
			}
		}
		System.out.println(answer);
	}
}
