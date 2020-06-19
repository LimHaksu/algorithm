import java.io.*;
import java.util.*;

public class n1367B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		while(test-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new  StringTokenizer(br.readLine());
			int oddCount = 0;
			int evenCount = 0;
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] % 2 != i % 2) {
					if(arr[i] % 2 == 0) {
						evenCount++;
					}else {
						oddCount++;
					}
				}
			}
			if(oddCount == evenCount) {
				answer.append(oddCount).append('\n');
			}else {
				answer.append("-1\n");
			}
		}
		System.out.print(answer);
	}
}
