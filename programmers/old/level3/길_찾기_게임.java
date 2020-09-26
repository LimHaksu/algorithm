import java.util.*;
class Solution {
	class Node{
		int num, x, y;
		Node left = null, right = null;
		Node(int num, int x, int y){
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	ArrayList<Integer> pre = new ArrayList<Integer>();
	ArrayList<Integer> post = new ArrayList<Integer>();
	public void setChild(Node parrent, Node child) {
		if(child.x > parrent.x) {
			if(parrent.right==null) {
				parrent.right = child;
				return;
			}else {
				setChild(parrent.right, child);
			}
		}else {
			if(parrent.left ==null) {
				parrent.left = child;
			}else {
				setChild(parrent.left, child);
			}
		}
	}
    public int[][] solution(int[][] nodeinfo) {
    	// x, y , y가 크면 위쪽
    	PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o2.y, o1.y);
			}
    	});
    	for(int i = 0; i < nodeinfo.length; ++i) {
    		pq.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
    	}
    	Node current = pq.remove();
    	Node root = current;
    	while(!pq.isEmpty()) {
    		current = pq.remove();
    		setChild(root, current);
    	}
    	dfsPre(root);
    	dfsPost(root);
        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; ++i) {
        	answer[0][i] = pre.get(i);
        	answer[1][i] = post.get(i);
        }
        return answer;
    }
    void dfsPre(Node current) {
    	pre.add(current.num);
    	if(current.left!=null) {
    		dfsPre(current.left);
    	}
    	if(current.right!=null) {
    		dfsPre(current.right);
    	}
    }
    void dfsPost(Node current) {
    	if(current.left!=null) {
    		dfsPost(current.left);
    	}
    	if(current.right!=null) {
    		dfsPost(current.right);
    	}
    	post.add(current.num);
    }
}
public class 길_찾기_게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		Solution sol = new Solution();
		int[][] result = sol.solution(nodeinfo);
		for(int i = 0; i < 2; ++i) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
}
