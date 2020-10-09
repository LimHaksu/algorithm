import java.io.*;
import java.util.*;

class Solution {
	int[] dr = {1, 0, -1};
	int[] dc = {0, 1, -1};
    public int[] solution(int n) {
        int len = n-1;
        int[][] arr = new int[n][n];
        int dir = 1;
        int num = 1;
        for(int i = 0; i < n; ++i) {
        	arr[i][0] = num++;
        }
        int cr = n-1;
        int cc = 0;
        while(len > 0) {
        	for(int i = 0; i < len; ++i) {
        		cr += dr[dir];
        		cc += dc[dir];
        		arr[cr][cc] = num++;
        	}
        	dir = (dir+1)%3;
        	len--;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i) {
        	for(int j = 0; j <=i; ++j) {
        		list.add(arr[i][j]);
        	}
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; ++i) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}

public class 삼각_달팽이 {
	public static void main(String[] args) throws Exception{
		int n = 6;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n)));
	}
}
