import java.io.*;
import java.util.*;

class Node {
	int index;
	int time;

	Node(int index, int time) {
		this.index = index;
		this.time = time;
	}
}

public class boj13549 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[200001];
		for (int i = 0; i <= 100000; ++i) {
			arr[i] = Integer.MAX_VALUE;
		}
		arr[n] = 0;
		Node current = new Node(n, 0);
		Deque<Node> q = new LinkedList<>();
		q.addLast(current);
		int answer = -1;
		w: while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; ++i) {
				current = q.pollFirst();
				if (current.index == k) {
					answer = current.time;
					break w;
				}
				if (current.index <= 50000 && current.time < arr[current.index * 2]) {
					arr[current.index * 2] = current.time;
					q.addFirst(new Node(current.index * 2, current.time));
				}
				if (current.index < 100000 && current.time + 1 < arr[current.index + 1]) {
					arr[current.index + 1] = current.time + 1;
					q.addLast(new Node(current.index + 1, current.time + 1));
				}
				if (current.index > 0 && current.time + 1 < arr[current.index - 1]) {
					arr[current.index - 1] = current.time + 1;
					q.addLast(new Node(current.index - 1, current.time + 1));
				}

			}
		}
		System.out.println(answer);
	}
}
