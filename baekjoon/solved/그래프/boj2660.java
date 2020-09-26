import java.io.*;
import java.util.*;

public class boj2660 {
	static int n;
	static boolean[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n+1][n+1];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1) {
				break;
			}
			arr[a][b] = true;
			arr[b][a] = true;
		}
		int min = Integer.MAX_VALUE;
		List<Integer> minList = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i) {
			int score = bfs(i);
			if(score < min) {
				min = score;
				minList = new ArrayList<Integer>();
				minList.add(i);
			}else if(score == min) {
				minList.add(i);
			}
		}
		StringBuilder ans = new StringBuilder();
		ans.append(min).append(' ').append(minList.size()).append('\n');
		for(int num : minList) {
			ans.append(num).append(' ');
		}
		System.out.println(ans);
	}
	
	static int bfs(int start) {
		boolean[] visited = new boolean[n+1];
		int current = start;
		visited[current] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(current);
		int score = -1;
		while(!q.isEmpty()) {
			int qsize = q.size();
			score++;
			for(int i = 0; i < qsize; ++i) {
				current = q.poll();
				for(int j = 1; j <= n; ++j) {
					if(!visited[j] && arr[current][j]) {
						visited[j] = true;
						q.add(j);
					}
				}
			}
		}
		return score;
	}
}
