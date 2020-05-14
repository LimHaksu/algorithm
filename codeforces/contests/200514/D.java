package D;

import java.io.*;
import java.util.*;

public class D {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1]-o1[0] > o2[1]-o2[0]) {
						return -1;
					}else if(o1[1]-o1[0] < o2[1]-o2[0]) {
						return 1;
					}
					return Integer.compare(o1[0], o2[0]);
				}
			});
			q.add(new int[] {1, n});
			for(int i = 1; i <= n; ++i) {
				int mid;
				int[] lra = q.remove();
				int l = lra[0];
				int r = lra[1];
				if((r-l+1)%2==1) {
					mid = (l+r)/2;
				}else {
					mid = (l+r-1)/2;
				}
				arr[mid] = i;
				int ll = l;
				int lr = mid-1;
				int rl = mid+1;
				int rr = r;
				if(rr-rl>lr-ll) {
					q.add(new int[] {rl, rr});
					q.add(new int[] {ll, lr});
				}else {
					q.add(new int[] {ll, lr});
					q.add(new int[] {rl, rr});
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; ++i) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			answer.append(sb);
		}
		System.out.println(answer);
	}
}
