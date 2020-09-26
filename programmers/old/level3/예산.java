class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < budgets.length; ++i) {
        	if(right < budgets[i]) right = budgets[i];
        }
        while(left <= right) {
        	int mid = (left + right)/2;
        	if(possible(budgets,mid,M)) {
        		answer = mid;
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        }
        return answer;
    }
    boolean possible(int[] budgets, int upperBound, int M) {
    	int sum = 0;
    	for(int i = 0; i < budgets.length; ++i) {
    		if(budgets[i] > upperBound) {
    			sum += upperBound;
    		}else {
    			sum += budgets[i];
    		}
    	}
    	return sum <= M;
    }
}
public class 예산 {
	public static void main(String[] args) {
//		int[] budgets = {120,110,140,150};
		int[] budgets = {2,2,2};
//		int M = 485;
		int M = 6;
		Solution sol = new Solution();
		System.out.println(sol.solution(budgets, M));
	}
}
