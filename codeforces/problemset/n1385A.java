import java.io.*;
import java.util.*;
public class n1385A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for(int i = 0; i < 3; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			StringBuilder ans = new StringBuilder();
			if(arr[1] == arr[2]) {
				ans.append("YES\n1 "+arr[0]+" "+arr[1]+"\n");
			}else {
				ans.append("NO\n");
			}
			answer.append(ans);
		}
		System.out.println(answer);
	}
}