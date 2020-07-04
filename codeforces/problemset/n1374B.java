import java.io.*;
import java.util.*;
public class n1374B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int threeCount = 0;
			int twoCount = 0;
			boolean check = true;
			while(n>1) {
				if(n%2==0) {
					twoCount++;
					n /= 2;
				}else if(n%3==0) {
					threeCount++;
					n /= 3;
				}else {
					check = false;
					break;
				}
			}
			if(check && threeCount >= twoCount) {
				answer.append(threeCount+(threeCount-twoCount)).append('\n');
			}else {
				answer.append("-1\n");
			}
		}
		System.out.println(answer);
	}
}
