import java.util.*;
import java.io.*;
public class boj2822 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> problems = new ArrayList<int[]>();
		for(int i = 0; i < 8; ++i) {
			problems.add(new int[] {i+1, Integer.parseInt(br.readLine())});
		}
		Collections.sort(problems, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		int sum = 0;
		ArrayList<Integer> idx = new ArrayList<Integer>();
		for(int i = 0; i < 5; ++i) {
			sum += problems.get(i)[1];
			idx.add(problems.get(i)[0]);
		}
		Collections.sort(idx);
		StringBuilder sb = new StringBuilder();
		for(int i : idx) {
			sb.append(i).append(' ');
		}
		System.out.println(sum);
		System.out.print(sb);
	}
}
