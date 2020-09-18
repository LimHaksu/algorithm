import java.io.*;
import java.util.*;

class Pair{
	int idx;
	int number;
	Pair(int idx, int number){
		this.idx = idx;
		this.number = number;
	}
	public String toString() {
		return "("+idx+", "+number+")";
	}
}

class DualPQ{
	PriorityQueue<Pair> maxPQ = new PriorityQueue<Pair>(new Comparator<Pair>() {
		@Override
		public int compare(Pair o1, Pair o2) {
			return Integer.compare(o2.number, o1.number);
		}
	});
	PriorityQueue<Pair> minPQ = new PriorityQueue<Pair>(new Comparator<Pair>() {
		@Override
		public int compare(Pair o1, Pair o2) {
			return Integer.compare(o1.number, o2.number);
		}
	});
	boolean[] visited;
	public DualPQ(int size) {
		this.visited = new boolean[size];
	}
	
	void add(Pair p) {
		this.maxPQ.add(p);
		this.minPQ.add(p);
	}
	
	int peekMin() {
		if(!minPQ.isEmpty()) {
			return minPQ.peek().number;
		}else {
			return peekMax();
		}
	}
	int peekMax() {
		if(!maxPQ.isEmpty()) {
			return maxPQ.peek().number;
		}else {
			return peekMin();
		}
	}
	
	int pollMin() {
		while(!minPQ.isEmpty()) {
			Pair p = minPQ.peek();
			if(!visited[p.idx]) {
				visited[p.idx] = true;
				return minPQ.poll().number;
			}else {
				minPQ.poll();
			}
		}
		return 0;
	}
	
	int pollMax() {
		while(!maxPQ.isEmpty()) {
			Pair p = maxPQ.peek();
			if(!visited[p.idx]) {
				visited[p.idx] = true;
				return maxPQ.poll().number;
			}else {
				maxPQ.poll();
			}
		}
		return 0;
	}
	
	boolean isEmpty() {
		while(!maxPQ.isEmpty()) {
			Pair p = maxPQ.peek();
			if(visited[p.idx]) {
				maxPQ.poll();
			}else {
				break;
			}
		}
		while(!minPQ.isEmpty()) {
			Pair p = minPQ.peek();
			if(visited[p.idx]) {
				minPQ.poll();
			}else {
				break;
			}
		}
		return maxPQ.isEmpty() || minPQ.isEmpty();
	}
	
}

public class boj7662{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 1; tc <= t; ++tc) {
			int k = Integer.parseInt(br.readLine());
			DualPQ dpq = new DualPQ(k);
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < k; ++j) {
				String[] splited = br.readLine().split(" ");
				String op = splited[0];
				int number = Integer.parseInt(splited[1]);
				switch(op) {
				case "I":
					dpq.add(new Pair(j, number));
					break;
				case "D":
					if(number == 1) {
						dpq.pollMax();
					}else {
						dpq.pollMin();
					}
					break;
				}
			}
			if(dpq.isEmpty()) {
				sb.append("EMPTY\n");
			}else {
				sb.append(dpq.peekMax()).append(' ').append(dpq.peekMin()).append('\n');
			}
			answer.append(sb);
		}
		System.out.println(answer);
	}
}