public class 땅따먹기 {
	static
	class Solution {
	    int solution(int[][] land) {
	        int answer = 0;
	        int[][] arr = new int[land.length][land[0].length];
	        for(int j = 0; j < arr[0].length; ++j) {
	        	arr[0][j] = land[0][j];
	        }
	        for(int i = 1; i < arr.length; ++i) {
	        	for(int j = 0; j < arr[i].length; ++j) {
	        		int max = 0;
	        		for(int k = 0; k < arr[i].length; ++k) {
	        			if(k!=j && arr[i-1][k] > max) {
	        				max = arr[i-1][k];
	        			}
	        		}
	        		arr[i][j] = max + land[i][j];
	        	}
	        }
	        for(int j = 0; j < arr[0].length; ++j){
	        	if(answer < arr[arr.length-1][j]) {
	        		answer = arr[arr.length-1][j];
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		Solution sol = new Solution();
		System.out.println(sol.solution(land));
	}
}
