import java.io.*;
import java.util.*;
public class n1373B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			String str = br.readLine();
			int count = 0;
			Stack<Character> stack = new Stack<Character>();
			stack.push(str.charAt(0));
			for(int i = 1; i < str.length(); ++i) {
				if(stack.isEmpty()) {
					stack.push(str.charAt(i));
				}else {
					if(str.charAt(i) == stack.peek()) {
						stack.push(str.charAt(i));
					}else {
						stack.pop();
						count++;
					}
				}
			}
			if(count%2==1) {
				answer.append("DA\n");
			}else {
				answer.append("NET\n");
			}
		}
		System.out.println(answer);
	}
}
