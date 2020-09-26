package A1;

import java.io.*;
import java.util.*;

class Solution {
	static int answer = 0;
    public int solution(int m, int n, String[] board) {
        char[][] newBoard = new char[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0;j < n; ++j) {
        		newBoard[i][j] = board[i].charAt(j);
        	}
        }
        while(checkToRemove(newBoard, m, n)) {
        	down(newBoard, m, n);
        }
        return answer;
    }
    
    boolean checkToRemove(char[][] board, int m, int n){
    	boolean[][] checked = new boolean[m][n];
    	boolean find = false;
    	for(int i = 0; i < m-1; ++i) {
    		for(int j = 0; j < n-1; ++j) {
    			if(board[i][j] != '0' && board[i][j] == board[i][j+1] && board[i][j] == board[i+1][j] && board[i+1][j] == board[i+1][j+1]) {
    				checked[i][j] = checked[i+1][j] = checked[i][j+1] = checked[i+1][j+1] = true;
    				find = true;
    			}
    		}
    	}
    	for(int i = 0; i < m; ++i) {
    		for(int j = 0; j < n; ++j) {
    			if(checked[i][j]) {
    				board[i][j] = '1';
    				answer++;
    			}
    		}
    	}
    	return find;
    }
    void down(char[][] board, int m, int n) {
    	for(int j = 0; j < n; ++j) {
    		for(int i = m-1; i >= 0; --i) {
    			if(board[i][j] == '1') {
    				downSub(board, i, j);
    				i++;
    			}
    		}
    	}
    }
    
    void print(char[][] board) {
    	for(int i = 0; i < board.length; ++i) {
    		System.out.println(Arrays.toString(board[i]));
    	}
    	System.out.println();
    }
    void downSub(char[][] board, int i, int j) {
    	while(i > 0) {
    		board[i][j] = board[i-1][j];
    		i--;
    	}
    	board[0][j] = '0';
    }
}

public class 프렌즈4블록 {
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {	"CCBDE", "AAADE", "AAABF", "CCBBF" };
		Solution sol = new  Solution();
		System.out.println(sol.solution(m, n, board));
	}
}
