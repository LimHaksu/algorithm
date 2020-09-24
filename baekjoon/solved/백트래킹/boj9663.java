import java.io.*;
import java.util.*;
public class boj9663 {
	static boolean[][] check;
	static int answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		check = new boolean[n][n];
		dfs(n, 0, 0, 0);
		System.out.println(answer);
	}
	
	static void print() {
		for(int i = 0; i < check.length; ++i) {
			System.out.println(Arrays.toString(check[i]));
		}
		System.out.println();
	}
	static void dfs(int n, int count, int i, int j) {
		if(count == n) {
			answer++;
			return;
		}
		for(int k = j; k < n; ++k) {
			if(isValidVertical(n, i, k) && isValidDiagonal(n, i, k)) {
				check[i][k] = true;
				dfs(n, count+1, i+1, 0);
				check[i][k] = false;
			}
		}
	}
	
	static boolean isValidVertical(int n, int i, int j) {
		for(int k = 0; k < n; ++k) {
			if(k != i && check[k][j]) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isValidDiagonal(int n, int i, int j) {
		// 11시
		int r = i-1;
		int c = j-1;
		while(bdCheck(n, r, c)) {
			if(check[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		// 1시
		r = i-1;
		c = j+1;
		while(bdCheck(n,r,c)) {
			if(check[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		// 5시
		r = i+1;
		c = j+1;
		while(bdCheck(n,r,c)) {
			if(check[r][c]) {
				return false;
			}
			r++;
			c++;
		}
		// 7시
		r = i+1;
		c = j-1;
		while(bdCheck(n,r,c)) {
			if(check[r][c]) {
				return false;
			}
			r++;
			c--;
		}
		return true;
	}
	static boolean bdCheck(int n, int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < n;
	}
}
