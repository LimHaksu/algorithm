import java.io.*;
import java.util.*;

public class boj1389 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(i != j) {
					arr[i][j] = 987654321;
				}
			}
		}
		for(int i = 0; i < m ; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for(int k = 1; k <= n; ++k) {
			for(int i = 1; i <= n; ++i) {
				for(int j = 1; j <= n; ++j) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		int[] sum = new int[n+1];
		int min = 987654321;
		List<Integer> minList = new ArrayList<>();
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				sum[i] += arr[i][j];
			}
			if(sum[i] < min) {
				min = sum[i];
				minList = new ArrayList<>();
				minList.add(i);
			}else if(sum[i] == min){
				minList.add(i);
			}
		}
		minList.sort((a,b)->{return a-b;});
		System.out.println(minList.get(0));
	}
}
