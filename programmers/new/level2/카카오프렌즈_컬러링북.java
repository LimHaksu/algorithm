import java.io.*;
import java.util.*;

class Solution {
	boolean[][] visited;
	int[] dr = {-1, 0, 1, 0};
	int[] dc = {0, 1, 0, -1};
	int[][] pic;
    public int[] solution(int m, int n, int[][] picture) {
    	pic = picture;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(!visited[i][j] && picture[i][j] > 0) {
        			visited[i][j] = true;
        			int size = dfs(i,j,0);
        			if(size > maxSizeOfOneArea) {
        				maxSizeOfOneArea = size;
        			}
        			numberOfArea++;
        		}
        	}
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    int dfs(int sr, int sc, int count) {
    	count++;
    	for(int i = 0; i < 4; ++i) {
    		int nr = sr + dr[i];
    		int nc = sc + dc[i];
    		if(bdCheck(nr,nc) && !visited[nr][nc] && pic[sr][sc] == pic[nr][nc]) {
    			visited[nr][nc] = true;
    			count = dfs(nr,nc,count);
    		}
    	}
    	return count;
    }
    boolean bdCheck(int r, int c) {
    	return r >= 0 && r < visited.length && c >= 0 && c < visited[0].length;
    }
}

public class 카카오프렌즈_컬러링북 {
	 public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(m, n, picture)));
	}
}
