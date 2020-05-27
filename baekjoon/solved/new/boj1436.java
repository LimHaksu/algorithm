package boj;

import java.io.*;
import java.util.*;

public class boj1436 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int number = 1;
		int count = 0;
		while(count < n) {
			if(check6(number)) {
				count++;
			}
			number++;
		}
		number--;
		System.out.println(number);
	}
	static boolean check6(int number) {
		int count = 0;
		while(number > 0) {
			if(number % 10 == 6) {
				count++;
			}else {
				count = 0;
			}
			if(count == 3) {
				return true;
			}
			number /= 10;
		}
		return false;
	}
}
