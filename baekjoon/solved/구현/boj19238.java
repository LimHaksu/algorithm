import java.io.*;
import java.util.*;

class Person implements Comparable<Person>{
	int num;
	int distance;
	int r, c;
	Person(int num, int distance, int r, int c){
		this.num = num;
		this.distance = distance;
		this.r = r;
		this.c = c;
	}
	@Override
	public int compareTo(Person o) {
		if(this.distance < o.distance) {
			return -1;
		}else if(this.distance > o.distance) {
			return 1;
		}else {
			if(this.r < o.r) {
				return -1;
			}else if(this.r > o.r){
				return 1;
			}
			return Integer.compare(this.c, o.c);
		}
	}
}
public class boj19238 {
	static int n, remain;
	static boolean[][] road;
	static int[][] personStart, personGoal;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		remain = Integer.parseInt(st.nextToken());
		road = new boolean[n+1][n+1];
		personStart = new int[n+1][n+1];
		int[][] personGoal = new int[m+1][2];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) {
					road[i][j] = true;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int cr = Integer.parseInt(st.nextToken());
		int cc = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= m; ++i) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			personStart[sr][sc] = i;
			personGoal[i][0] = er;
			personGoal[i][1] = ec;
		}
		boolean fail = false;
		for(int i = 1; i <= m; ++i) {
			int[] closestPerson = findClosestPerson(cr, cc);
			int pNum = closestPerson[0];
			if(pNum == -1) {
				fail = true;
				break;
			}
			int pr = closestPerson[1];
			int pc = closestPerson[2];
			personStart[pr][pc] = 0;
			int dist = closestPerson[3];
			if(dist > remain) {
				fail = true;
				break;
			}
			remain -= dist;
			int pgr = personGoal[pNum][0];
			int pgc = personGoal[pNum][1];
			int moveDistance = distance(pr, pc, pgr, pgc);
			if(moveDistance == -1) {
				fail = true;
				break;
			}
			if(moveDistance > remain) {
				fail = true;
				break;
			}
			remain += moveDistance;
			cr = pgr;
			cc = pgc;
		}
		if(fail) {
			System.out.println(-1);
		}else {
			System.out.println(remain);
		}
	}
	
	// 출발지부터 목적지까지 거리 구하기
	static int distance(int sr, int sc, int er, int ec) {
		int[] current = {sr, sc};
		boolean[][] visited = new boolean[n+1][n+1];
		visited[sr][sc] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(current);
		int distance = -1;
		while(!q.isEmpty()) {
			int qsize = q.size();
			distance++;
			for(int i = 0; i < qsize; ++i) {
				current = q.poll();
				int cr = current[0];
				int cc = current[1];
				if(cr == er && cc == ec) {
					return distance;
				}
				for(int j = 0; j < 4; ++j) {
					int nr = cr + dr[j];
					int nc = cc + dc[j];
					if(bdCheck(nr, nc) && road[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		return -1;
	}
	
	// 가장 가까운 손님의 number, r, c, distance 리턴
	// 없으면 -1 리턴
	static int[] findClosestPerson(int cr, int cc){
		PriorityQueue<Person> pq = new PriorityQueue<>();
		int[] current = {cr, cc};
		boolean[][] visited = new boolean[n+1][n+1];
		visited[cr][cc] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(current);
		int distance = -1;
		boolean find = false;
		while(!q.isEmpty()) {
			int qsize = q.size();
			distance++;
			for(int i = 0; i < qsize; ++i) {
				current = q.poll();
				cr = current[0];
				cc = current[1];
				if(personStart[cr][cc] > 0) {
					find = true;
					pq.add(new Person(personStart[cr][cc], distance, cr, cc));
				}
				for(int j = 0; j < 4; ++j) {
					int nr = cr + dr[j];
					int nc = cc + dc[j];
					if(bdCheck(nr, nc) && road[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		if(find) {
			Person p = pq.poll();
			return new int[] {p.num, p.r, p.c, p.distance}; 
		}
		return new int[] {-1};
	}
	
	static boolean bdCheck(int r, int c) {
		return r >= 1 && r <= n && c >= 1 && c <= n;
	}
}
