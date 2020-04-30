package boj;
import java.io.*;
import java.util.*;
public class boj1655 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		});
		PriorityQueue<Integer> big = new  PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			big.add(Integer.parseInt(br.readLine()));
			if(big.size() > small.size()) {
				small.add(big.remove());
			}
			if(small.size() > 0 && big.size() > 0 && small.element() > big.element()) {
				big.add(small.remove());
				small.add(big.remove());
			}
			sb.append(small.element()).append('\n');
		}
		System.out.println(sb);
	}
}
