import java.io.*;
import java.util.*;
public class n1009{
	public static void main(String[] args) throws Exception{
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		int[][] d={{10},{1},{6,2,4,8},{1,3,9,7},{6,4},{5},{6},{1,7,9,3},{6,8,4,2},{1,9}};
		StringBuilder p=new StringBuilder();
		for(int c=1;c<=t;++c){
			StringTokenizer s=new StringTokenizer(r.readLine());
			int a=Integer.parseInt(s.nextToken());
			int b=Integer.parseInt(s.nextToken());
			p.append(d[a%10][b%d[a%10].length]).append('\n');
		}
		System.out.println(p);
	}
}