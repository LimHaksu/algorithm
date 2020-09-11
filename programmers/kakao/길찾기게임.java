import java.io.*;
import java.util.*;

class Node {
	int num, x, y;
	Node lc = null;
	Node rc = null;

	Node(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Solution {
	ArrayList<Integer> pre = new ArrayList<Integer>();
	ArrayList<Integer> post = new ArrayList<Integer>();

	public int[][] solution(int[][] nodeinfo) {
		ArrayList<Node> nodeArr = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; ++i) {
			nodeArr.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
		}
		// y 큰거, x 작은 순
		nodeArr.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.y > o2.y) {
					return -1;
				} else if (o1.y < o2.y) {
					return 1;
				}
				return Integer.compare(o1.x, o2.x);
			}
		});
		Node root = nodeArr.get(0);
		for (int i = 1; i < nodeArr.size(); ++i) {
			addNode(root, nodeArr.get(i));
		}
		preorder(root);
		postorder(root);
		int[][] answer = new int[2][nodeinfo.length];
		for(int i = 0; i < nodeinfo.length; ++i) {
			answer[0][i] = pre.get(i);
		}
		for(int i = 0; i < nodeinfo.length; ++i) {
			answer[1][i] = post.get(i);
		}
		return answer;
	}

	void preorder(Node current) {
		if (current == null) {
			return;
		}
		pre.add(current.num);
		preorder(current.lc);
		preorder(current.rc);
	}

	void postorder(Node current) {
		if(current == null) {
			return;
		}
		postorder(current.lc);
		postorder(current.rc);
		post.add(current.num);
	}
	
	void addNode(Node currentTree, Node node) {
		if (node.x < currentTree.x) {
			if (currentTree.lc == null) {
				currentTree.lc = node;
			} else {
				addNode(currentTree.lc, node);
			}
		} else {
			if (currentTree.rc == null) {
				currentTree.rc = node;
			} else {
				addNode(currentTree.rc, node);
			}
		}
	}
}

public class 길찾기게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		Solution sol = new Solution();
		int[][] result = sol.solution(nodeinfo);
		for (int i = 0; i < result.length; ++i) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
