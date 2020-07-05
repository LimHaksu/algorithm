import java.io.*;
import java.util.*;
public class n1374C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0; i < n; ++i) {
				if(stack.isEmpty()) {
					stack.push(s.charAt(i));
				}else {
					if(s.charAt(i) == ')' && stack.peek() == '(') {
						stack.pop();
					}else {
						stack.push(s.charAt(i));
					}
				}
			}
			answer.append(stack.size()/2).append('\n');
		}
		System.out.println(answer);
	}
}
