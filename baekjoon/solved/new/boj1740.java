import java.io.*;
import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = find(0, n);
        return answer;
    }
    // start로부터 distance만큼 떨어져있는 숫자 찾기
    long find(long start, long distance) {
    	if(distance==0) {
    		return 0;
    	}
        // 열 : 3의 n승부터 시작하는 숫자들
    	// n번째 숫자가 몇번째 열에 있는지 찾기
        long currentColSize = 1;
        long sumOfSize = 0;
        
        int count = 0;
        while(sumOfSize < distance) {
        	sumOfSize += currentColSize;
        	currentColSize *= 2;
        	count++;
        }
        count--;
        currentColSize /= 2;
        sumOfSize -= currentColSize;
        long currentNum = 1;
        while(count >0) {
        	count--;
        	currentNum *= 3;
        }
        return currentNum + find(currentNum, (distance-(sumOfSize+1)));
    }
}

public class boj1740 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
		sc.close();
	}
}