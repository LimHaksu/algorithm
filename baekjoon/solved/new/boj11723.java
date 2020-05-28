import java.util.*;
import java.io.*;
public class boj11723 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		Set<Integer> set = new HashSet<Integer>();
		while(m-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken();
			int num = -1;
			if(!op.equals("all") && !op.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			switch(op) {
			case "add":
				set.add(num);
				break;
			case "check":
				answer.append(set.contains(num)?1:0).append('\n');
				break;
			case "remove":
				if(set.contains(num)) {
					set.remove(num);
				}
				break;
			case "toggle":
				if(set.contains(num)) {
					set.remove(num);
				}else {
					set.add(num);
				}
				break;
			case "all":
				for(int i = 1; i <= 20; ++i) {
					set.add(i);
				}
				break;
			case "empty":
				for(int i = 1; i <= 20; ++i) {
					if(set.contains(i)) {
						set.remove(i);
					}
				}
				break;
			}
		}
		System.out.println(answer);
	}
}
