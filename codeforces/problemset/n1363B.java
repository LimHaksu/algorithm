import java.io.*;
import java.util.*;
public class n1363B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			String s = br.readLine();
			int[] oneCount = new int[s.length()+1];
			int totalOneCount = 0;
			for(int i = 1; i < oneCount.length; ++i) {
				if(s.charAt(i-1)=='1') {
					totalOneCount++;
				}
				oneCount[i] = totalOneCount;
			}
			// i번째 이전의 1의 갯수 oneCount[i]
			// i번째 이전의 0의 갯수 i-oneCount[i]
			// i번째 이후의 1의 갯수 totalOneCount - oneCount[i]
			// i번째 이후의 0의 갯수 (s.length()-totalOneCount) - (i-oneCount[i])
			int min = s.length();
			for(int i = 0; i < oneCount.length; ++i) {
				// 01
				min = Math.min(min, oneCount[i]+(s.length()-totalOneCount)-(i-oneCount[i]));
				// 10
				min = Math.min(min,  i-oneCount[i]+totalOneCount-oneCount[i]);
			}
			answer.append(min).append('\n');
		}
		System.out.println(answer);
	}
}
