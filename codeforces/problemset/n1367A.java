import java.io.*;
import java.util.*;
public class n1367A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder answer = new  StringBuilder();
		while(test-->0) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(0));
			for(int i = 2; i < s.length()-1; i += 2) {
				sb.append(s.charAt(i));
			}
			sb.append(s.charAt(s.length()-1));
			answer.append(sb).append('\n');
		}
		System.out.println(answer);
	}
}
