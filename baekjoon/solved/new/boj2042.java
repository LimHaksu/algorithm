import java.io.*;
import java.util.*;
public class boj2042 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		// 높이는 h = ceil( log_2(n) )
		// 필요한 노드는 2^(h+1) - 1
		// 예를 들어 리프가 3개면 높이는 2이고 필요한 노드는 7개
		int h = (int)Math.ceil(Math.log10(n)/Math.log10(2));
		int treeSize = (1 << (h+1));
		long[] tree = new long[treeSize];
		m += k;
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(arr,tree,1,0,n-1);
		StringBuilder answer = new StringBuilder();
		while(m-->0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				b -= 1;
				long diff = c - arr[b];
				arr[b] = c;
				update(arr, tree, 1, 0, n-1, b, diff);
			}else if( a== 2) {
				answer.append(sum(tree,1,0,n-1,b-1,(int)c-1)).append('\n');
			}
		}
		System.out.println(answer);
	}
	static long init(long[] arr, long[] tree, int node, int left, int right) {
		// begin, end는 node가 담당하는 구역(arr의 index 구역)
		// 둘이 같으면 그 자리의 node에 값을 넣는다.
		if(left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left + right) /2;
		return tree[node] = init(arr,tree,node*2, left, mid)
						  + init(arr,tree,node*2+1, mid+1, right);
	}
	
	static void update(long[] arr, long[] tree, int node, int left, int right, int index, long diff) {
		// node는 heap 구조에서 index를 의미, 1부터 시작 -> x2는 왼쪽 자식, x2+1는 오른쪽 자식
		// begin, end는 node가 담당하는 구역을 의미
		// index는 arr의 index를 의미. node가 담당하는 begin, end와 비교대상
		if( index < left || index > right) {
			return;
		}
		tree[node] += diff;
		if(left != right) {
			int mid = (left + right) / 2;
			update(arr, tree, node*2, left, mid, index, diff);
			update(arr, tree, node*2+1, mid+1, right, index, diff);
		}
	}
	static long sum(long[] tree, int node, int left, int right, int begin, int end) {
		// node 범위가 구하려는 영역 밖일 경우
		if(left > end || right < begin) {
			return 0;
		}
		// 노드 범위가 구하려는 범위 안일경우 -> 노드 값 자체를 리턴하면 해당 구간의 합은 바로 구할 수 있음
		if(begin <= left && right <= end) {
			return tree[node];
		}
		int mid = (left + right) / 2;
		return sum(tree, node*2, left, mid, begin, end)
			  +sum(tree, node*2+1, mid+1, right,begin, end);
	}
}
