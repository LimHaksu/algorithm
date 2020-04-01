package Two;
import java.util.*;
class Solution {
	int[] weakPoint;
	int answer = Integer.MAX_VALUE;
	int nn;
    public int solution(int n, int[] weak, int[] dist) {
        nn = n;
        weakPoint = new int[weak.length*2];
        for(int i = 0; i < weak.length; ++i) {
        	weakPoint[i] = weakPoint[i+weak.length] = weak[i];
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] checked = new boolean[dist.length];
        dfs(stack, checked, dist);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    void dfs(Stack<Integer> stack, boolean[] checked, int[] dist) {
    	if(stack.size() == checked.length) {
    		int[] idx = new int[stack.size()];
    		int idxIdx = 0;
    		for(int n : stack) {
    			idx[idxIdx++] = n;
    		}
    		// idx : dist의 순서를 담은 인덱스;
    		// 시계방향
    		for(int s = 0; s < weakPoint.length/2; ++s) {
    			int count = 0; // tempWeak 카운트
    			idxIdx = 0;
    			int end = weakPoint.length/2+s;
				for (int i = s; i < end; ++i) {
					count++;
					int current = weakPoint[i];
					int d = dist[idx[idxIdx++]];
					while (d-- > 0) {
						if (i == end) {
							break;
						}
						current++;
						if(current == nn) {
							current = 0;
						}
						if (current == weakPoint[i + 1]) {
							i++;
							count++;
						}
					}
					if (idxIdx == idx.length) {
						break;
					}
				}
				if(count >= weakPoint.length/2) {
					if(idxIdx < answer) {
						answer = idxIdx;
					}
				}
    		}
    		return;
    	}
    	for(int i = 0; i < checked.length; ++i) {
    		if(!checked[i]) {
    			checked[i] = true;
    			stack.push(i);
    			dfs(stack, checked, dist);
    			stack.pop();
    			checked[i] = false;
    		}
    	}
    }
}
public class Two {
	public static void main(String[] args) {
		int n = 5;
		int[] weak = {1,3,4,9,10};
		int[] dist = {3,5,7};
		Solution sol = new Solution();
		System.out.println(sol.solution(n, weak, dist));
	}
}