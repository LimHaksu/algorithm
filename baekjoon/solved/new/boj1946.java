import java.io.*;
import java.util.*;
public class boj1946 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			StringTokenizer st;
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			int count = 1;
			int rank = arr[0][1];
			for(int i = 1; i < n; ++i) {
				if(arr[i][1] < rank) {
					count++;
					rank = arr[i][1];
				}
			}
			answer.append(count).append('\n');
		}
		System.out.println(answer);
	}
}
