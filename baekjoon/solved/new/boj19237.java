import java.io.*;
import java.util.*;

class Shark{
	int number;
	int direction; // 1 위 , 2 아래, 3 왼, 4 오른
	int r, c;
	int[][] priority = new int[5][5];
	boolean alive = true;
	Shark(int number) {
		this.number = number;
	}
}

public class boj19237 {
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	static int n, m, k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Shark[] sharks = new Shark[m+1];
		for(int i = 1; i <= m; ++i) {
			sharks[i] = new Shark(i);
		}
		
		int[][][] arr = new int[n][n][2]; // 0 상어번호, 1 남은 시간(0 되면 상어번호 사라짐)
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j][0] = Integer.parseInt(st.nextToken());
				if(arr[i][j][0] > 0) {
					arr[i][j][1] = k;
					sharks[arr[i][j][0]].r = i;
					sharks[arr[i][j][0]].c = j;
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= m; ++i) {
			sharks[i].direction = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= m; ++i) {
			int[][] priority = new int[5][5];
			for(int j = 1; j <= 4; ++j) {
				st = new StringTokenizer(br.readLine());
				for(int p = 1; p <= 4; ++p) {
					priority[j][p] = Integer.parseInt(st.nextToken());
				}
			}
			sharks[i].priority = priority;
		}
		
		int count = 0;
		while(countSharkAlive(sharks) > 1) {
			count++;
			if(count>1000) {
				break;
			}
			step(arr, sharks);
		}
		System.out.println(count<=1000?count:-1);
	}
	
	static void countMinusOne(int[][][] arr) {
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(arr[i][j][1] > 0) {
					arr[i][j][1]--;
					if(arr[i][j][1] == 0) {
						arr[i][j][0] = 0;
					}
				}
			}
		}
	}
	
	static void markCurrentLocation(Shark[] sharks, int[][][] arr) {
		for(int i = 1; i <= m; ++i) {
			if(sharks[i].alive) {
				int cr = sharks[i].r;
				int cc = sharks[i].c;
				arr[cr][cc][0] = sharks[i].number;
				arr[cr][cc][1] = k;
			}
		}
	}
	static void move(Shark s, int[][][] arr) {
		if(s.alive) {
			int[] nrcd = findNextRCD(s, arr);
			s.r = nrcd[0];
			s.c = nrcd[1];
			s.direction = nrcd[2];
		}
	}
	
	static boolean bdCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}
	static int[] findNextRCD(Shark s, int[][][] arr) {
		int[] priority = s.priority[s.direction];
		int cr = s.r;
		int cc = s.c;
		int selfDirection = -1;
		for(int i = 1; i <= 4; ++i) {
			int nr = cr + dr[priority[i]];
			int nc = cc + dc[priority[i]];
			if(bdCheck(nr, nc)) {
				if(arr[nr][nc][0] == 0) {
					return new int[] {nr, nc, priority[i]};
				}else if(arr[nr][nc][0] == s.number) {
					if(selfDirection == -1) {
						selfDirection = priority[i];
					}
				}
			}
		}
		return new int[] {cr + dr[selfDirection], cc + dc[selfDirection], selfDirection};
	}
	
	static int countSharkAlive(Shark[] sharks) {
		int count = 0;
		for(int i = 1; i <= m; ++i) {
			if(sharks[i].alive) {
				count++;
			}
		}
		return count;
	}
	
	static void step(int[][][] arr, Shark[] sharks) {
		// 상어 움직임
		for(int i = 1; i <= m; ++i) {
			move(sharks[i], arr);
		}
		// 상어 흔적 있는 곳 배열 카운트 1씩 감소
		countMinusOne(arr);
		//같은 곳 있는 상어 제거
		for(int i = 1; i < m; ++i) {
			if(sharks[i].alive) {
				for(int j = i+1; j <= m; ++j) {
					if(sharks[i].r == sharks[j].r && sharks[i].c == sharks[j].c) {
						sharks[j].alive = false;
					}
				}
			}
		}
		// 상어 현재 위치 표시
		markCurrentLocation(sharks, arr);
	}
}
