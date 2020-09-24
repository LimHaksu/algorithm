import java.util.*;
import java.io.*;
public class boj9251 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] arr = new int[s1.length()+1][s2.length()+1];
		for(int i = 1; i < arr.length; ++i) {
			char c1 = s1.charAt(i-1);
			for(int j = 1; j < arr[0].length; ++j) {
				char c2 = s2.charAt(j-1);
				if(c1 == c2) {
					arr[i][j] = arr[i-1][j-1]+1;
				}else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		System.out.println(arr[s1.length()][s2.length()]);
	}
}
