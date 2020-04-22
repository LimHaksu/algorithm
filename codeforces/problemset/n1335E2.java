package E;

import java.io.*;
import java.util.*;

public class E {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int tc = 1; tc <= t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			ArrayList<ArrayList<Integer>> index = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= 200; ++i) {
				index.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < n; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				index.get(arr[i]).add(i);
			}
			int[][] partSum = new int[201][n];
			for(int i = 1; i <= 200; ++i) {
				if(arr[0] == i) {
					partSum[i][0] = 1;
				}
			}
			for(int j = 1; j < n; ++j) {
				for(int i = 1; i <= 200; ++i) {
					if(arr[j] == i) {
						partSum[i][j] = partSum[i][j-1]+1;
					}else {
						partSum[i][j] = partSum[i][j-1];
					}
				}
			}
			int max = 0;
			for (int i = 1; i <= 200; ++i) {
				int size = index.get(i).size() / 2;
				int fr = -1;
				int to = n;
				for (int k = 1; k <= 200; ++k) {
					int len = 0;
					if (k != i) {
						len += index.get(k).size();
					}
					if (len > max) {
						max = len;
					}
				}
				for (int j = 0; j < size; ++j) {
					fr = index.get(i).get(j);
					to = index.get(i).get(index.get(i).size() - j - 1)-1;
					if(fr<to) {
						for (int k = 1; k <= 200; ++k) {
							int len = (j + 1) * 2;
							len += partSum[k][to]-partSum[k][fr];
							if(len > max) {
								max = len;
							}
						}
					}
				}
			}
			answer.append(max).append('\n');
		}
		System.out.println(answer);
	}
}
