package A1;
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < moves.length; ++i) {
        	int col = moves[i]-1;
        	int doll = getDoll(board, col);
        	if(doll != -1) {
        		if(stack.isEmpty()) {
        			stack.push(doll);
        		}else {
        			if(stack.peek() == doll) {
        				stack.pop();
        				answer += 2;
        			}else {
        				stack.push(doll);
        			}
        		}
        	}
        }
        return answer;
    }
    int getDoll(int[][] board, int col) {
    	for(int i = 0; i < board.length; ++i) {
    		if(board[i][col]>0) {
    			int num = board[i][col];
    			board[i][col] = 0;
    			return num;
    		}
    	}
    	return -1;
    }
}
public class 크레인_인형뽑기_게임 {
	public static void main(String[] args) throws Exception{
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		Solution sol = new Solution();
		System.out.println(sol.solution(board, moves));
	}
}
