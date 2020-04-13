class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4]; // 0~ 10 , urdl순
        int cr = 5;
        int cc = 5;
        int nc = cc;
        int nr = cr;
        for(int i = 0; i < dirs.length(); ++i) {
        	switch(dirs.charAt(i)) {
        	case 'L':
        		nc = cc-1;
                    nr = cr;
        		if(bdCheck(nr, nc)) {
                    visited[cr][cc][3] = true;
        			cc = nc;
        		}
        		break;
        	case 'U':
        		nr = cr-1;
                    nc = cc;
        		if(bdCheck(nr,nc)) {
                    visited[cr][cc][0] = true;
        			cr = nr;
        		}
        		break;
        	case 'R':
        		nc = cc+1;
                    nr = cr;
        		if(bdCheck(nr,nc)) {
                    visited[cr][cc][1] = true;
        			cc = nc;
        		}
        		break;
        	case 'D':
        		nr = cr+1;
                    nc = cc;
        		if(bdCheck(nr,nc)) {
                    visited[cr][cc][2] = true;
        			cr = nr;
        		}
        		break;
        	}
        }
        for(int i = 0; i < visited.length; ++i) {
        	for(int j = 0; j < visited[0].length; ++j) {
                for(int k = 0; k < 4; ++k){
                    if(visited[i][j][k]) {
                        if(k==0 && i >0){
                            if(visited[i-1][j][2]) continue;
                        }
                        if(k==3 && j >0){
                            if(visited[i][j-1][1]) continue;
                        }
        		    	answer++;
        		    }   
                }
        	}
        }
        return answer;
    }
    boolean bdCheck(int r, int c) {
    	return r >= 0 && r < 11 && c >= 0 && c < 11;
    }
}
public class 방문_길이 {
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		Solution sol = new Solution();
		System.out.println(sol.solution(dirs));
	}
}
