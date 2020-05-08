import java.io.*;
import java.util.*;
public class boj10868 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int h = (int)(Math.ceil(Math.log10(n)/Math.log10(2)));
		int treeSize = 1 << (h+1);
		int[] tree = new int[treeSize];
		for(int i = 0; i < treeSize; ++i) {
			tree[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(arr, tree, 1, 0, n-1);
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			answer.append(find(tree,1,0,n-1,a-1,b-1)).append('\n');
		}
		System.out.println(answer);
	}
	static int init(int[] arr, int[] tree, int node, int left, int right) {
		if(left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left + right) / 2;
		return tree[node] = Math.min(init(arr, tree, node*2, left, mid), init(arr, tree, node*2+1, mid+1, right)); 
	}
	static int find(int[] tree, int node, int left, int right, int begin, int end) {
		if(begin > right || end < left) {
			return Integer.MAX_VALUE;
		}
		if(begin <= left && right <= end) {
			return tree[node];
		}
		int mid = (left + right) /2;
		return Math.min(find(tree, node*2, left, mid, begin, end), find(tree, node*2+1, mid+1, right, begin, end));
	}
}
