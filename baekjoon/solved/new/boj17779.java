import java.io.*;
import java.util.*;
public class boj17779 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n-1; ++i) {
			for(int j = 1; j < n-1; ++j) {
				int x1 = i, y1 = j;
				int x3 = i+1, y3 = j-1;
				while(bdCheck(x3, y3, n)) {
					int x2 = x1+1, y2 = y1+1;
					int x4 = x3+1, y4 = y3+1;
					while(bdCheck(x2,y2,n) && bdCheck(x4,y4,n)) {
						calc(arr,x1,y1,x2,y2,x3,y3,x4,y4);
						x2++;
						y2++;
						x4++;
						y4++;
					}
					x3++;
					y3--;
				}
			}
		}
		System.out.println(ans);
	}
	static boolean bdCheck(int r, int c, int n) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	static void calc(int[][] arr, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int[] a = new int[5];
		int n = arr.length;
		for(int x = 0; x < n; ++x) {
			for(int y = 0; y < n; ++y) {
				if(x>=0 && x < x3 && y >= 0 && y <= y1 && x+y < x1+y1) {
					a[0] += arr[x][y];
				}else if(0<= x && x <= x2 && y1 < y && y < n && x-y < x1-y1) {
					a[1] += arr[x][y];
				}else if(x3 <= x && x < n && 0 <= y && y < y4 && x-y > x3-y3) {
					a[2] += arr[x][y];
				}else if(x2 < x && x < n && y4 <= y && y < n && x+y > x2 + y2) {
					a[3] += arr[x][y];
				}else if(x+y >= x1+y1 && x+y <= x2+y2 && x-y >= x1-y1 && x-y <= x3- y3) {
					a[4] += arr[x][y];
				}
			}
		}
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i = 0; i < 5; ++i) {
			if(a[i] > max) {
				max = a[i];
			}
			if(a[i] < min) {
				min = a[i];
			}
		}
		int diff = max - min;
		if(diff < ans) {
			ans = diff;
		}
	}
}
