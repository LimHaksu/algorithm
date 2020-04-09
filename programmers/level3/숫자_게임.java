import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        ArrayList<Integer> alB = new ArrayList<Integer>();
        for(int b : B) {
        	alB.add(b);
        }
        alB.sort(new Comparator<Integer>() {
        	public int compare(Integer a, Integer b) {
        		return Integer.compare(a,b);
        	}
		});
        for(int i = 0; i < A.length; ++i) {
        	int idx = find(alB, A[i]);
        	if(idx != -1) {
        		answer++;
        		alB.remove(idx);
        	}else {
        		alB.remove(0);
        	}
        }
        return answer;
    }
    // target 이상인 숫자 중 가장 작은 수의 index 반환, 존재하지 않으면  index 0 반환
    int find(ArrayList<Integer> B, int target) {
    	int left = 0;
    	int right = B.size()-1;
    	int ans = -1;
    	while(left <= right) {
    		int mid = (left+right)/2;
    		if(B.get(mid) > target) {
    			ans = mid;
    			right = mid-1;
    		}else {
    			left = mid+1;
    		}
    	}
    	return ans;
    }
}
public class 숫자_게임 {
	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		Solution sol = new Solution();
		System.out.println(sol.solution(A, B));
	}
}
