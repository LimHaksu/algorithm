import java.io.*;
import java.util.*;
public class boj9426 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k  = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> small = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		PriorityQueue<Integer> big = new PriorityQueue<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		long sum = 0;
		for(int i = 0; i < n; ++i) {
			int temp = Integer.parseInt(br.readLine());
			big.add(temp);
			q.add(temp);
			if(q.size()>k) {
				int r = q.remove();
				if(big.contains(r)) {
					big.remove(r);
					big.add(small.poll());
				}else {
					small.remove(r);
					small.add(big.poll());
				}
			}
			if(big.size() > 0 && small.size() > 0 && big.peek() < small.peek()) {
				int btemp = big.poll();
				int stemp = small.poll();
				small.add(btemp);
				big.add(stemp);
			}
			if(big.size() > small.size()) {
				small.add(big.poll());
			}
			if(i >= k-1) {
				sum += small.peek();
			}
		}
		System.out.println(sum);
	}
}
