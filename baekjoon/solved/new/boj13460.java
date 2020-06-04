package boj;
import java.io.*;
import java.util.*;
public class boj13460 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		int[] redrc = {}, bluerc = {}, goalrc = {};
		for(int i = 0; i < n; ++i) {
			String line = br.readLine();
			for(int j = 0; j < m; ++j) {
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'R') {
					redrc = new int[] {i,j};
					board[i][j] = '.';
				}else if(board[i][j] == 'B') {
					bluerc = new int[] {i,j};
					board[i][j] = '.';
				}else if(board[i][j] == 'O') {
					goalrc = new int[] {i,j};
					board[i][j] = '.';
				}
			}
		}
		int[][] redblue = new int[2][];
		redblue[0] = redrc;
		redblue[1] = bluerc;
		Queue<int[][]> q = new LinkedList<int[][]>();
		q.add(redblue);
		int count = 0;
		w: while(!q.isEmpty() && count <= 10) {
			int size = q.size();
			count++;
			for(int i = 0; i < size; ++i) {
				int[][] currentRedblue = q.poll();
				int[] currentRed = currentRedblue[0];
				int[] currentBlue = currentRedblue[1];
				int[][] nextRedBlue = up(board,currentRed, currentBlue, goalrc);
				if(nextRedBlue[0][0] == -1) {
					break w;
				}else if(nextRedBlue[0][0] != -2) {
					q.add(nextRedBlue);
				}
				nextRedBlue = down(board,currentRed, currentBlue, goalrc);
				if(nextRedBlue[0][0] == -1) {
					break w;
				}else if(nextRedBlue[0][0] != -2) {
					q.add(nextRedBlue);
				}
				nextRedBlue = left(board,currentRed, currentBlue, goalrc);
				if(nextRedBlue[0][0] == -1) {
					break w;
				}else if(nextRedBlue[0][0] != -2) {
					q.add(nextRedBlue);
				}
				nextRedBlue = right(board,currentRed, currentBlue, goalrc);
				if(nextRedBlue[0][0] == -1) {
					break w;
				}else if(nextRedBlue[0][0] != -2) {
					q.add(nextRedBlue);
				}
			}
		}
		if(count <= 10) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}
	}
	static void print(char[][] board) {
		for(int i = 0; i < board.length; ++i) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
	}
	static boolean bdCheck(char[][] board, int r, int c) {
		return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
	}
	// [0][0] == -1 빨강이 구멍에 빠짐
	// [0][0] == -2 파랑이 구멍에 빠짐
	static int[][] up(char[][] board, int[] redrc, int[] bluerc, int[] goalrc) {
		int[][] ball = new int[2][];
		boolean redFirst = true;
		// 빨강이 위면 빨강먼저, 파랑이 위면 파랑먼저
		if(redrc[0] < bluerc[0]) {
			ball[0] = redrc.clone();
			ball[1] = bluerc.clone();
		}else {
			redFirst = false;
			ball[0] = bluerc.clone();
			ball[1] = redrc.clone();
		}
		boolean[] rbgoal = new boolean[2];
		for(int i = 0; i < 2; ++i) {
			int nr = ball[i][0]-1;
			int c = ball[i][1];
			while(bdCheck(board, nr,c) && board[nr][c] == '.') {
				if(nr == goalrc[0] && c == goalrc[1]) {
					if(i==0) {
						if(redFirst) {
							rbgoal[0] = true;
						}else {
							rbgoal[1] = true;
						}
					}else {
						if(redFirst) {
							rbgoal[1] = true;
						}else {
							rbgoal[0] = true;
						}
					}
				}
				nr--;
			}
			ball[i][0] = nr+1;
		}
		if(ball[0][0] == ball[1][0] && ball[0][1] == ball[1][1]) {
			ball[1][0]++;
		}
		if(!redFirst) {
			int[] temp = ball[0];
			ball[0] = ball[1];
			ball[1] = temp;
		}
		if(rbgoal[1]) {
			return new int[][] {{-2}};
		}
		if(rbgoal[0]) {
			return new int[][] {{-1}};
		}
		return ball;
	}
	static int[][] down(char[][] board, int[] redrc, int[] bluerc, int[] goalrc) {
		int[][] ball = new int[2][];
		boolean redFirst = true;
		// 빨강이 아래면 빨강먼저, 파랑이 아래면 파랑먼저
		if(redrc[0] > bluerc[0]) {
			ball[0] = redrc.clone();
			ball[1] = bluerc.clone();
		}else {
			redFirst = false;
			ball[0] = bluerc.clone();
			ball[1] = redrc.clone();
		}
		boolean[] rbgoal = new boolean[2];
		for(int i = 0; i < 2; ++i) {
			int nr = ball[i][0]+1;
			int c = ball[i][1];
			while(bdCheck(board, nr,c) && board[nr][c] == '.') {
				if(nr == goalrc[0] && c == goalrc[1]) {
					if(i==0) {
						if(redFirst) {
							rbgoal[0] = true;
						}else {
							rbgoal[1] = true;
						}
					}else {
						if(redFirst) {
							rbgoal[1] = true;
						}else {
							rbgoal[0] = true;
						}
					}
				}
				nr++;
			}
			ball[i][0] = nr-1;
		}
		if(ball[0][0] == ball[1][0] && ball[0][1] == ball[1][1]) {
			ball[1][0]--;
		}
		if(!redFirst) {
			int[] temp = ball[0];
			ball[0] = ball[1];
			ball[1] = temp;
		}
		if(rbgoal[1]) {
			return new int[][] {{-2}};
		}
		if(rbgoal[0]) {
			return new int[][] {{-1}};
		}
		return ball;
	}
	static int[][] left(char[][] board, int[] redrc, int[] bluerc, int[] goalrc) {
		int[][] ball = new int[2][];
		boolean redFirst = true;
		// 빨강이 왼쪽이 빨강먼저, 파랑이 왼쪽이면 파랑먼저
		if(redrc[1] < bluerc[1]) {
			ball[0] = redrc.clone();
			ball[1] = bluerc.clone();
		}else {
			redFirst = false;
			ball[0] = bluerc.clone();
			ball[1] = redrc.clone();
		}
		boolean[] rbgoal = new boolean[2];
		for(int i = 0; i < 2; ++i) {
			int r = ball[i][0];
			int nc = ball[i][1]-1;
			while(bdCheck(board, r,nc) && board[r][nc] == '.') {
				if(r == goalrc[0] && nc == goalrc[1]) {
					if(i==0) {
						if(redFirst) {
							rbgoal[0] = true;
						}else {
							rbgoal[1] = true;
						}
					}else {
						if(redFirst) {
							rbgoal[1] = true;
						}else {
							rbgoal[0] = true;
						}
					}
				}
				nc--;
			}
			ball[i][1] = nc+1;
		}
		if(ball[0][0] == ball[1][0] && ball[0][1] == ball[1][1]) {
			ball[1][1]++;
		}
		if(!redFirst) {
			int[] temp = ball[0];
			ball[0] = ball[1];
			ball[1] = temp;
		}
		if(rbgoal[1]) {
			return new int[][] {{-2}};
		}
		if(rbgoal[0]) {
			return new int[][] {{-1}};
		}
		return ball;
	}
	static int[][] right(char[][] board, int[] redrc, int[] bluerc, int[] goalrc) {
		int[][] ball = new int[2][];
		boolean redFirst = true;
		// 빨강이 오른쪽이면 빨강먼저, 파랑이 오른쪽이면 파랑먼저
		if(redrc[1] > bluerc[1]) {
			ball[0] = redrc.clone();
			ball[1] = bluerc.clone();
		}else {
			redFirst = false;
			ball[0] = bluerc.clone();
			ball[1] = redrc.clone();
		}
		boolean[] rbgoal = new boolean[2];
		for(int i = 0; i < 2; ++i) {
			int r = ball[i][0];
			int nc = ball[i][1]+1;
			while(bdCheck(board, r,nc) && board[r][nc] == '.') {
				if(r == goalrc[0] && nc == goalrc[1]) {
					if(i==0) {
						if(redFirst) {
							rbgoal[0] = true;
						}else {
							rbgoal[1] = true;
						}
					}else {
						if(redFirst) {
							rbgoal[1] = true;
						}else {
							rbgoal[0] = true;
						}
					}
				}
				nc++;
			}
			ball[i][1] = nc-1;
		}
		if(ball[0][0] == ball[1][0] && ball[0][1] == ball[1][1]) {
			ball[1][1]--;
		}
		if(!redFirst) {
			int[] temp = ball[0];
			ball[0] = ball[1];
			ball[1] = temp;
		}
		if(rbgoal[1]) {
			return new int[][] {{-2}};
		}
		if(rbgoal[0]) {
			return new int[][] {{-1}};
		}
		return ball;
	}
}
