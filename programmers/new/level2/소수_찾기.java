import java.io.*;
import java.util.*;
class Solution {
	int len = 10000000;
    boolean[] prime = new boolean[len];
    boolean[] visited = new boolean[len];
    Set<Integer> set = new HashSet<Integer>();
	public int solution(String numbers) {
        for(int i = 2; i < len; ++i) {
        	if(!visited[i]) {
        		prime[i] = true;
        		for(int j = i; j < len; j += i) {
        			visited[j] = true;
        		}
        	}
        }
        for(int i = 1; i <= numbers.length(); ++i) {
        	selectN(numbers, i);
        }
        return set.size();
    }
	void selectN(String numbers, int n) {
		int[] idx = new int[numbers.length()];
        for(int i = 0; i < idx.length; ++i) {
        	idx[i] = i;
        }
        
        do {
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i < n; ++i) {
        		sb.append(numbers.charAt(idx[i]));
        	}
        	int num = Integer.parseInt(sb.toString());
        	if(prime[num]) {
        		set.add(num);
        	}
        }while(nextPermutation(idx));
	}
    
    boolean nextPermutation(int[] arr) {
    	int idx = -1;
    	for(int i = 0; i < arr.length-1; ++i) {
    		if(arr[i] < arr[i+1]) {
    			idx = i;
    		}
    	}
    	if(idx==-1) {
    		return false;
    	}
    	int idx2 = arr.length-1;
    	for(int j = idx2; j > idx; --j) {
    		if(arr[j] > arr[idx]) {
    			idx2 = j;
    			break;
    		}
    	}
    	int temp = arr[idx];
    	arr[idx] = arr[idx2];
    	arr[idx2] = temp;
    	for(int i = idx+1; i <= (idx+arr.length)/2; ++i) {
    		temp = arr[i];
    		arr[i] = arr[arr.length-(i-idx)];
    		arr[arr.length-(i-idx)] = temp;
    	}
    	return true;
    }
}
public class 소수_찾기 {
	public static void main(String[] args) throws Exception{
		String numbers = "17";
		Solution sol = new Solution();
		System.out.println(sol.solution(numbers));
	}
}
