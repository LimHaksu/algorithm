import java.util.*;
import java.io.*;
public class boj1049 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int [m][2];
		int minP = Integer.MAX_VALUE;
		int minS = Integer.MAX_VALUE;
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(arr[i][0] < minP) {
				minP = arr[i][0];
			}
			if(arr[i][1] < minS) {
				minS = arr[i][1];
			}
		}
		if(minS*6 <= minP) {
			minP = minS*6;
		}
		int ans = 0;
		while(n>0) {
			if(n>=6) {
				ans += minP;
				n-=6;
			}else {
				if(n*minS > minP) {
					ans += minP;
				}else {
					ans += minS*n;
				}
				break;
			}
		}
		System.out.println(ans);
	}
}
