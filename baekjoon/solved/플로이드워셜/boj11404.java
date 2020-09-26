import java.io.*;
import java.util.*;

public class boj11404 {
	public static void main(String[] args) throws Exception{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n ;++j) {
				if(i!=j) {
					arr[i][j] = 10000001;
				}
			}
		}
		for(int i =  0; i < m; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(arr[from][to] > cost) {
				arr[from][to] = cost;
			}
		}
		for(int k = 1; k <=n ;++k) {
			for(int i = 1; i <= n; ++i) {
				for(int j = 1; j <= n; ++j) {
					if(arr[i][k] + arr[k][j] < arr[i][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(arr[i][j] == 10000001) {
					ans.append(0);
				}else {
					ans.append(arr[i][j]);
				}
				ans.append(' ');
			}
			ans.append('\n');
		}
		System.out.println(ans);
	}
}
