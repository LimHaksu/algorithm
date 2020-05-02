package A;

import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String m = st.nextToken();
			int move = 0;
			int ans = -1;
			if(x==0 && y==0) {
				answer.append("Case #"+tc+": 0\n");
				continue;
			}
			for(int i = 0; i < m.length(); ++i) {
				switch(m.charAt(i)){
				case 'N':
					y++;
					break;
				case 'E':
					x++;
					break;
				case 'S':
					y--;
					break;
				case 'W':
					x--;
					break;
				}
				move++;
				int diff = Math.abs(y)+Math.abs(x);
				if(diff <= move) {
					ans = move;
					break;
				}
			}
			if(ans > 0) {
				answer.append("Case #"+tc+": "+ans+"\n");
			}else {
				answer.append("Case #"+tc+": IMPOSSIBLE\n");
			}
		}
		System.out.println(answer);
	}
}