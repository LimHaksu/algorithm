import java.io.*;
import java.util.*;
public class n1355D {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		// k or s-k 인 합이 있으면 vasya 승, else petya 승
		// k는  petya가 정함, 배열의 합은 s여야함
		// 목표 s-k 또는 k 를 못만들게 k 와 배열 설정
		// 1, 2, ..., n-1, n 번째 요소일때 1~n-1 다 합쳐도 n번째 요소 못만들게
		int[] arr = new int[n];
		for(int i = 0; i < n-1; ++i) {
			arr[i] = 1;
		}
		arr[n-1] = s-(n-1);
		if(arr[n-1]-1 <= n-1) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <  n; ++i) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			sb.append(arr[n-1]-1);
			System.out.println(sb);
		}
	}
}
