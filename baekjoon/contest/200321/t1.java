package boj;

import java.util.*;
import java.io.*;
public class t1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[k][][];
		int[][] board = new int[n][m];
		for(int i = 0; i < k; ++i) {
			int r, c;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[r][c];
			for(int rr = 0 ; rr < r; ++rr) {
				st = new StringTokenizer(br.readLine());
				for(int cc = 0; cc < c; ++cc) {
					sticker[rr][cc] = Integer.parseInt(st.nextToken());
				}
			}
			arr[i] = sticker;
		}
		for(int i = 0; i < k; ++i) {
			int[][] sticker = arr[i];
			for(int j = 0;j < 4; ++j) {
				if(checkStricker(board, sticker)) {
					break;
				}
				sticker = rotateSticker(sticker);
			}
		}
		int count = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(board[i][j] > 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		
	}
	static int[][] rotateSticker(int[][] sticker){
		int nr = sticker[0].length;
		int nc = sticker.length;
		int[][] newSticker = new int[nr][nc];
		for(int i = 0; i < sticker.length; ++i) {
			for(int j = 0; j < sticker[0].length; ++j) {
				newSticker[j][sticker.length-1-i] = sticker[i][j];
			}
		}
		return newSticker;
	}
	static void copy(int[][] board, int[][] sticker, int sr, int sc) {
		for(int i = 0; i < sticker.length; ++i) {
			for(int j = 0; j < sticker[0].length; ++j) {
				if(sticker[i][j]>0) {
					board[sr+i][sc+j] = sticker[i][j];
				}
			}
		}
	}
	static boolean checkStricker(int[][] board, int[][] sticker) {
		for(int i = 0; i < board.length; ++i) {
			for(int j = 0; j < board[0].length; ++j) {
				if(check(board,sticker,i,j)) {
					copy(board,sticker,i,j);
					return true;
				}
			}
		}
		return false;
	}
	static boolean check(int[][] board, int[][] sticker, int sr, int sc) {
		if(sr+sticker.length > board.length || sc+sticker[0].length > board[0].length) {
			return false;
		}
		for(int i = 0; i < sticker.length; ++i) {
			for(int j = 0; j < sticker[0].length; ++j) {
				if(sticker[i][j] > 0 && board[sr+i][sc+j] > 0) {
					return false;
				}
			}
		}
		return true;
	}
}
