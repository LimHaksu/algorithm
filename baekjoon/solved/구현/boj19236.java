import java.io.*;
import java.util.*;

class Shark{
	int direction, r, c;
	Shark(int direction, int r, int c){
		this.direction = direction;
		this.r = r;
		this.c = c;
	}
}
class Fish{
	int direction, r, c;
	boolean alive;
	Fish(int d, int r, int c, boolean alive){
		this.direction = d;
		this.r = r;
		this.c = c;
		this.alive = alive;
	}
	void rotate() {
		this.direction++;
		if(this.direction > 8) {
			this.direction -= 8;
		}
	}
}
public class boj19236 {
	static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] fishNumMap = new int[4][4]; // 상어는 -1번
		Fish[] fishes = new Fish[17];
		for(int i = 0; i < 4; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; ++j) {
				int fishNum = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				fishNumMap[i][j] = fishNum;
				fishes[fishNum] = new Fish(direction, i, j, true);
			}
		}
		int fishNum = fishNumMap[0][0];
		int d = fishes[fishNum].direction;
		fishes[fishNum].alive = false;
		Shark s = new Shark(d, 0, 0);
		fishNumMap[0][0] = -1;
		dfs(s, fishes, fishNumMap, fishNum);
		System.out.println(ans);
	}
	
	static void printMap(int[][] map) {
		for(int i = 0; i < 4; ++i) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	
	static void dfs(Shark s, Fish[] fishes, int[][] fishNumMap, int sum) {
		if(sum > ans) {
			ans = sum;
		}
		moveAllFish(fishes, fishNumMap);
		for(int i = 1; i <= 3; ++i) {
			int[] nextSharkRC = sharkNstep(s, i, fishNumMap);
			if(nextSharkRC[0] == -1) {
				continue;
			}
			Shark ns = copyShark(s);
			int nr = nextSharkRC[0];
			int nc = nextSharkRC[1];
			
			Fish[] nFishes = copyFishes(fishes);
			int[][] nFishNumMap = copyFishNumMap(fishNumMap);
			int fishNum = nFishNumMap[nr][nc];
			Fish f = nFishes[fishNum];
			eatFish(ns, f, nFishNumMap);
			dfs(ns,nFishes, nFishNumMap, sum + fishNum);
		}
	}
	
	static int[][] copyFishNumMap(int[][] fnm){
		int[][] ret = new int[4][4];
		for(int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				ret[i][j] = fnm[i][j];
			}
		}
		return ret;
	}
	
	static Fish[] copyFishes(Fish[] fishes) {
		Fish[] ret = new Fish[fishes.length];
		for(int i = 1; i < ret.length; ++i) {
			ret[i] = new Fish(fishes[i].direction, fishes[i].r, fishes[i].c, fishes[i].alive);
		}
		return ret;
	}
	
	static Shark copyShark(Shark s) {
		return new Shark(s.direction, s.r, s.c);
	}
	
	static void eatFish(Shark s, Fish f, int[][] fishNumMap) {
		fishNumMap[f.r][f.c] = -1;
		fishNumMap[s.r][s.c] = 0;  
		f.alive = false;
		s.direction = f.direction;
		s.r = f.r;
		s.c = f.c;
	}
	
	// 1~3칸 점프했을때, 이동 불가능 하면 -1 리턴
	static int[] sharkNstep(Shark s, int n, int[][] fishNumMap) {
		int nr = s.r + dr[s.direction] * n;
		int nc = s.c + dc[s.direction] * n;
		if(bdCheck(nr,nc) && fishNumMap[nr][nc] > 0) {
			return new int[] {nr,nc};
		}
		return new int[] {-1};
	}
	
	static void moveAllFish(Fish[] fishes, int[][] fishNumMap) {
		for(int i = 1; i <= 16; ++i) {
			if(fishes[i].alive) {
				Fish f = fishes[i];
				int[] nrc = getNextRC(f, fishNumMap);
				if(nrc[0] == -1) {
					continue;
				}
				int nr = nrc[0];
				int nc = nrc[1];
				if(fishNumMap[nr][nc] > 0) {
					Fish f2 = fishes[fishNumMap[nr][nc]];
					change2Fish(f, f2, fishNumMap);
				}else if(fishNumMap[nr][nc] == 0) {
					moveFish(f, nr, nc, fishNumMap);
				}
			}
		}
	}
	
	static void moveFish(Fish f1, int nr, int nc, int[][] fishNumMap) {
		fishNumMap[nr][nc] = fishNumMap[f1.r][f1.c];
		fishNumMap[f1.r][f1.c] = 0; 
		f1.r = nr;
		f1.c = nc;
	}
	
	static void change2Fish(Fish f1, Fish f2, int[][] fishNumMap) {
		int temp = fishNumMap[f1.r][f1.c];
		fishNumMap[f1.r][f1.c] = fishNumMap[f2.r][f2.c];
		fishNumMap[f2.r][f2.c] = temp;
		int rtemp = f1.r;
		int ctemp = f1.c;
		f1.r = f2.r;
		f1.c = f2.c;
		f2.r = rtemp;
		f2.c = ctemp;
	}
	
	// -1 반환하면 이동 불가능
	static int[] getNextRC(Fish f, int[][] fishNumMap) {
		for(int i = 0; i < 8; ++i) {
			int nr = f.r + dr[f.direction];
			int nc = f.c + dc[f.direction];
			if(bdCheck(nr,nc) && fishNumMap[nr][nc] >= 0) {
				return new int[] {nr, nc};
			}
			f.rotate();
		}
		return new int[] {-1};
	}
	
	static boolean bdCheck(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
}
