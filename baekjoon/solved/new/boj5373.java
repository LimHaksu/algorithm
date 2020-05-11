import java.io.*;
import java.util.*;
public class boj5373 {
	// 전개도 그려서 풀자 3이 앞면
	/*    0 1 2 3 4 5 6 7 8 9 10 11
	 * 0        0 0 0
	 * 1        0 0 0
	 * 2        0 0 0
	 * 3  1 1 1 3 3 3 4 4 4 5 5 5
	 * 4  1 1 1 3 3 3 4 4 4 5 5 5
	 * 5  1 1 1 3 3 3 4 4 4 5 5 5
	 * 6        2 2 2
	 * 7        2 2 2
	 * 8        2 2 2
	 * 
	 */
	static int[][] arr = new int[9][12];
	static char[] intToColor = {'w', 'g', 'y', 'r', 'b', 'o'};
	static void rotate(int num, int d) {
		int[][] temp = new int[3][3];
		switch(num) {
		case 0:
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i][j+3];
				}
			}
			
			break;
		case 1:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i+3][j];
				}
			}
			break;
		case 2:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i+6][j+3];
				}
			}
			break;
		case 3:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i+3][j+3];
				}
			}
			break;
		case 4:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i+3][j+6];
				}
			}
			break;
		case 5:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp[i][j] = arr[i+3][j+9];
				}
			}
			break;
		}
		int[][] newTemp = new int[3][3];
		if(d == 0) {
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					newTemp[i][j] = temp[2-j][i];
				}
			}
		}else {
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					newTemp[i][j] = temp[j][2-i];
				}
			}
		}
		switch(num) {
		case 0:
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i][j+3] = newTemp[i][j];
				}
			}
			
			break;
		case 1:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i+3][j] = newTemp[i][j];
				}
			}
			break;
		case 2:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i+6][j+3] = newTemp[i][j];
				}
			}
			break;
		case 3:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i+3][j+3] = newTemp[i][j];
				}
			}
			break;
		case 4:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i+3][j+6] = newTemp[i][j];
				}
			}
			break;
		case 5:

			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					arr[i+3][j+9] = newTemp[i][j];
				}
			}
			break;
		}
	}
	static void init() {
		for(int i = 0; i < 3; ++i) {
			for(int j = 3; j < 6; ++j) {
				arr[i][j] = 0;
			}
		}
		for(int i = 3; i < 6; ++i) {
			for(int j = 0; j < 3; ++j) {
				arr[i][j] = 1;
			}
			for(int j = 3; j < 6; ++j) {
				arr[i][j] = 3;
			}
			for(int j = 6; j < 9; ++j) {
				arr[i][j] = 4;
			}
			for(int j = 9; j < 12; ++j) {
				arr[i][j] = 5;
			}
		}
		for(int i = 6; i < 9; ++i) {
			for(int j = 3; j < 6; ++j) {
				arr[i][j] = 2;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		// 윗면 흰, 아래 노란, 앞 빨, 뒤 오렌지, 왼 초록, 오른 파란
		//    c0, c1, c2
		// r0
		// r1
		// r2
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			init();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; ++i) {
				String op = st.nextToken();
				switch(op.charAt(0)) {
				case 'U':
					if(op.charAt(1)=='+') {
						rotateH(0,0);
						rotate(0,0);
					}else {
						rotateH(0,1);
						rotate(0,1);
					}
					break;
				case 'D':
					if(op.charAt(1)=='+') {
						rotateH(2,1);
						rotate(2,0);
					}else {
						rotateH(2,0);
						rotate(2,1);
					}					
					break;
				case 'F':
					if(op.charAt(1)=='+') {
						rotateP(0,0);
						rotate(3,0);
					}else {
						rotateP(0,1);
						rotate(3,1);
					}
					break;
				case 'B':
					if(op.charAt(1)=='+') {
						rotateP(2,1);
						rotate(5,0);
					}else {
						rotateP(2,0);
						rotate(5,1);
					}
					break;
				case 'L':
					if(op.charAt(1)=='+') {
						rotateV(0,1);
						rotate(1,0);
					}else {
						rotateV(0,0);
						rotate(1,1);
					}
					break;
				case 'R':
					if(op.charAt(1)=='+') {
						rotateV(2,0);
						rotate(4,0);
					}else {
						rotateV(2,1);
						rotate(4,1);
					}
					break;
				}
			}
			answer.append(getTop());
//			print();
//			answer.append(getFront());
		}
		System.out.println(answer);
	}
	static String getTop() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; ++i) {
			for(int j = 3; j < 6; ++j) {
				sb.append(intToColor[arr[i][j]]);
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	static void print() {
		for(int i = 0; i < 9; ++i) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
	static String getFront() {
		StringBuilder sb = new StringBuilder();
		for(int i = 3; i < 6; ++i) {
			for(int j = 3; j < 6; ++j) {
				sb.append(intToColor[arr[i][j]]);
			}
			sb.append('\n');
		}
		return sb.toString();
	}
	// 세로방향 회전 ( c, d ) // c 열 번호, d 0 윗방향, 1 아래방향
	static void rotateV(int c, int d) {
		// d == 0 윗방향
		// 3 -> 0 -> 5 -> 2 -> 3
		// 0을 우선 temp로 보내고 3을 0자리로 2를 3자리로 5를 2자리로 temp를 5자리로
		
		// 0을 temp 로 
		int[][] temp = new int[3][3];
		for(int i = 0; i < 3; ++i) {
			temp[i][c] = arr[i][c+3];
		}
		if(d==0) {
			// 3을 0으로, 2를 3으로 v
			for(int i = 0; i < 6; ++i) {
					arr[i][3+c] = arr[i+3][3+c];
			}
			// 5를 2로 v
			for(int i = 6; i < 9; ++i) {
					arr[i][3+c] = arr[5-(i-6)][11-c];
			}
			// temp를 5로 v
			for(int i = 3; i < 6; ++i) {
					arr[i][11-c] = temp[2-(i-3)][c];
			}
		}else {
			// d == 1 아래방향
			// 3 <- 0 <- 5 <- 2 <- 3
			// 0을 우선 temp로 보내고 5을 0자리로 2를 5자리로 3를 2자리로 temp를3자리로
			
			// 5를 0자리로 v
			for(int i = 0; i < 3; ++i) {
					arr[i][3+c] = arr[5-i][11-c];
			}
			// 2를 5로  v
			for(int i = 3; i < 6; ++i) {
					arr[i][11-c] = arr[8-(i-3)][3+c];
			}
			// 3을 2로 v
			for(int i = 6; i < 9; ++i) {
					arr[i][3+c] = arr[i-3][3+c];
			}
			// temp를 3으로 v
			for(int i = 3; i < 6; ++i) {
					arr[i][3+c] = temp[i-3][c];
			}
		}
	}
	
	// 가로방향 회전 ( r, d) // r  행번호, d 0시계방향, 1 반시계방향
	static void rotateH(int r, int d) {
		// d == 0 시계방향
		// 3 -> 1 -> 5 -> 4 -> 3
		// 1을 우선 temp로 보내고 3을 1자리로 4를 3자리로 5를 4자리로 temp를 5자리로
		
		// 1을 temp로
		int[][] temp = new int[3][3];
			for(int j = 0; j < 3; ++j) {
				temp[r][j] = arr[r+3][j];
			}
		if(d == 0) {
			// 3을 1로 , 4를 3으로, 5를 4로
				for(int j = 0; j < 9; ++j) {
					arr[3+r][j] = arr[3+r][j+3];
				}
			// temp를 5로
				for(int j = 9; j < 12; ++j) {
					arr[3+r][j] = temp[r][j-9];
				}
		}else {
			// 3 <- 1 <- 5 <- 4 <- 3
			// 5를 1로
				for(int j = 0; j < 3; ++j) {
					arr[3+r][j] = arr[3+r][j+9];
				}
			// 4를 5로 , 3을 4로
				for(int j = 11; j >= 6; --j) {
					arr[3+r][j] = arr[3+r][j-3];
				}
			// temp를 3으로
				for(int j = 3; j < 6; ++j) {
					arr[3+r][j] = temp[r][j-3];
				}
		}
	}
	
	// 면 방향 회전 ( k, d) // k 몇번째 면인지, d 시계방향, 1 반시계방향
	static void rotateP(int k, int d) {
		// d == 0 시계바향
		// 0 -> 4 -> 2 -> 1 ->
		// 0을 temp로 , 1을 0으로, 2를 1로, 4를 2로 , temp를 4로
		
		// 0을 temp로
		int[][] temp = new int[3][3];
			for(int j = 0; j < 3; ++j) {
				temp[2-k][j] = arr[2-k][j+3];
		}
		if(d==0) {
			// 1을 0으로
				for(int j = 3; j < 6; ++j) {
					arr[2-k][j] = arr[5-(j-3)][2-k];
				}
			// 2를 1로
			for(int i = 3; i < 6; ++i) {
					arr[i][2-k] = arr[6+k][i];
				}
			// 4를 2로
				for(int j = 3; j < 6; ++j) {
					arr[6+k][j] = arr[5-(j-3)][6+k];
				}
			// temp를 4로
			for(int i = 3; i < 6; ++i) {
					arr[i][6+k] = temp[2-k][i-3];
			}
		}else {
			// d == 0 시계바향
			// 0 <- 4 <- 2 <- 1 <- 0
			// 0을 temp로 , 4을 0으로, 2를 4로, 1를 2로 , temp를 1로
			
			// 4를 0으로
				for(int j = 3; j < 6; ++j) {
					arr[2-k][j] = arr[j][6+k];
				}
			// 2를 4로
			for(int i = 3; i < 6; ++i) {
					arr[i][6+k] = arr[6+k][5-(i-3)];
				}
			// 1을 2로
				for(int j = 3; j < 6; ++j) {
					arr[6+k][j] = arr[j][2-k];
				}
			// temp를 1로
			for(int i = 3; i < 6; ++i) {
					arr[i][2-k] = temp[2-k][2-(i-3)];
				}
		}
	}
	
}
