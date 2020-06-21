import java.io.*;
public class n1368B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long k = Long.parseLong(br.readLine());
		String s = "codeforces";
		int[] count = new int[10];
		for(int i = 0; i < count.length; ++i) {
			count[i] = 1;
		}
		while(true) {
			long mul = getMul(count);
			if(mul >= k) {
				break;
			}
			int minIdx = findMinIdx(count);
			count[minIdx]++;
		}
		for(int i = 0; i < count.length; ++i) {
			for(int j = 0 ; j < count[i]; ++j) {
				System.out.print(s.charAt(i));
			}
		}
	}
	static long getMul(int[] count) {
		long result = 1;
		for(int i = 0; i < count.length; ++i) {
			result *= (long)count[i];
		}
		return result;
	}
	static int findMinIdx(int[] count) {
		int minIdx = 0;
		for(int i = 1; i < count.length; ++i) {
			if(count[i] < count[minIdx]) {
				minIdx = i;
			}
		}
		return minIdx;
	}
}
