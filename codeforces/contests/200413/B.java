package B;
import java.io.*;
import java.util.*;

public class B2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			StringBuilder tsb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			int[] arr= new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int mid = arr.length/2;
			tsb.append(arr[mid]);
			int left = mid -1;
			int right = mid +1;
			while(left >=0 || right < arr.length) {
				if(left>=0) {
					tsb.append(" "+arr[left--]);
				}
				if(right < arr.length) {
					tsb.append(" "+arr[right++]);
				}
			}
			sb.append(tsb).append('\n');
		}
		System.out.println(sb);
	}
}
