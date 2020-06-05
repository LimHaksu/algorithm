import java.util.*;
import java.io.*;

public class boj17837 {
	static class Node{
		int num;
		int r, c;
		Node next = null;
		Node prev = null;
		int direction;
		Node(int num, int d, int r, int c){
			this.num = num;
			this.direction = d;
			this.r = r;
			this.c = c;
		}
		public String toString() {
			return ""+(this.num+1)+" : ("+this.r+" , "+this.c+")";
		}
	}
	static int n;
	static Node[] nodeArr;
	static int[][] board;
	static Node[][] boardTop;
	static int[] dr = {0,0,0,-1,1};
	static int[] dc = {0,1,-1,0,0};
	static int turn;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		boardTop = new Node[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nodeArr = new Node[k];
		for(int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			nodeArr[i] = new Node(i, d, r, c);
			boardTop[r][c] = nodeArr[i];
		}
		turn = 0;
		w: while(turn <= 1000) {
			turn++;
			for(int i = 0; i < k; ++i) {
				move(i);
				if(checkAllNodeEqualPosition()) {
					break w;
				}
			}
		}
		System.out.println(turn>1000?-1:turn);
	}
	static void print() {
		for(int i = 0; i < nodeArr.length; ++i) {
			Node current = nodeArr[i];
			while(current!=null) {
				System.out.print(current+" ");
				current = current.next;
			}
			System.out.println();
		}
	}
	static boolean checkAllNodeEqualPosition() {
		for(int i = 0; i < nodeArr.length; ++i) {
			Node current = nodeArr[i];
			int count = 0;
			while(current != null) {
				count++;
				current = current.next;
				if(count >= 4) {
					return true;
				}
			}

		}
		return false;
	}
	static void moveSub(int i, int nr, int nc) {
		Node current = nodeArr[i];
		// 아래에 있는 노드와 연결 끊기
		if(current.prev!=null) {
			boardTop[current.r][current.c] = current.prev; 
			current.prev.next = null;
			current.prev = null;
		}else {
			boardTop[current.r][current.c] = null;
		}
		// 하양이면 그대로 이동
		if(board[nr][nc] == 0) {
			current.r = nr;
			current.c = nc;
			if(boardTop[nr][nc] != null) {
				boardTop[nr][nc].next = current;
				current.prev = boardTop[nr][nc];
			}else {
				current.prev = null;
			}
			boardTop[nr][nc] = current;
			current = current.next;
			while(current!=null) {
				current.r = nr;
				current.c = nc;
				boardTop[nr][nc] = current;
				current = current.next;
			}
			boardTop[nr][nc].next = null;
		}
		// 빨강이면 뒤집어서 이동
		else if(board[nr][nc] == 1) {
			Stack<Node> stack = new Stack<>();
			while(current!=null) {
				current.r = nr;
				current.c = nc;
				stack.push(current);
				current = current.next;
			}
			while(!stack.isEmpty()) {
				current = stack.pop();
				current.next = null;
				if(boardTop[nr][nc] != null) {
					boardTop[nr][nc].next = current;
					current.prev = boardTop[nr][nc];
				}else {
					current.prev = null;
				}
				boardTop[nr][nc] = current;
			}
		}
	}
	static void move(int i) {
		int cr = nodeArr[i].r;
		int cc = nodeArr[i].c;
		int nr = cr + dr[nodeArr[i].direction];
		int nc = cc + dc[nodeArr[i].direction];
		// 이동 가능하면 이동
		if(moveCheck(nr,nc)) {
			moveSub(i, nr,nc);
		}else {
			// 이동 불가능 하면 반대로 이동
			if(nodeArr[i].direction <= 2) {
				nodeArr[i].direction = 3 - nodeArr[i].direction;
			}else {
				nodeArr[i].direction = 7 - nodeArr[i].direction;
			}
			nr = cr + dr[nodeArr[i].direction];
			nc = cc + dc[nodeArr[i].direction];
			if(moveCheck(nr,nc)) {
				moveSub(i, nr, nc);
			}
		}
	}
	static boolean moveCheck(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n && board[r][c] != 2;
	}
}
