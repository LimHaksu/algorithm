import java.io.*;
import java.util.*;
public class boj1592 {
	static int n, m, l;
	static int[] count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int current = 1;
		count = new int[n+1];
		count[current]++;
		int answer = 0;
		while(count[current] < m) {
			current = next(current);
			count[current]++;
			answer++;
		}
		System.out.println(answer);
	}
	static int next(int current) {
		int ret = current;
		if(count[current]%2 == 1) {
			ret += l;
			if(ret > n) {
				ret -= n;
			}
		}else {
			ret -= l;
			if(ret < 1) {
				ret += n;
			}
		}
		return ret;
	}
}
