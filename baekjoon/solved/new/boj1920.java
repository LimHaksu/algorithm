import java.io.*;
import java.util.*;
public class boj1920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			if(find(arr,Integer.parseInt(st.nextToken()))) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.print(sb);
	}
	static boolean find(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] < target) {
				left = mid+1;
			}else if(arr[mid] > target) {
				right = mid - 1;
			}else {
				return true;
			}
		}
		return false;
	}
}
