package programmers;
import java.io.*;
import java.util.*;
public class K번째수 {
	static 
	class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        for(int idx = 0; idx < commands.length; ++idx) {
	        	int i = commands[idx][0]-1;
	        	int j = commands[idx][1]-1;
	        	int k = commands[idx][2]-1;
	        	int size = j-i+1;
	        	int[] splited = new int[size];
	        	for(int s = i; s <= j; ++s) {
	        		splited[s-i] = array[s];
	        	}
	        	Arrays.sort(splited);
	        	answer[idx] = splited[k];
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(array, commands)));
	}
}
