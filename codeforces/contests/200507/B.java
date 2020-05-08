package B;

import java.io.*;
import java.util.*;

public class B {
	static int[] arr = new int[25819];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		int add = 5;
		int num = 2;
		int idx = 0;
		while(num <= 1000000000) {
			arr[idx] = num;
			num += add;
			add += 3;
			idx++;
		}
		System.out.println(arr[arr.length-1]);
		for (int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			while(n > 0) {
				int index = findIdx(n);
				if(index == -1) {
					break;
				}
				n -= arr[index];
				count++;
			}
			answer.append(count).append('\n');
		}
		System.out.println(answer);
	}
	static int findIdx(int num) {
		int left = 0;
		int right = arr.length-1;
		int result = -1;
		while(left <= right) {
			int mid = (left + right) /2;
			if(arr[mid] <= num) {
				result = mid;
				left = mid + 1;
			}else {
				right = mid -1;
			}
		}
		return result;
	}
}
