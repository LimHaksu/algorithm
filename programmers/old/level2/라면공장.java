import java.util.*;
public class 라면공장 {
	static
	class Solution {
		class Node implements Comparable<Node>{
			int supply;
			int date;
			Node(int supply, int date){
				this.supply = supply;
				this.date = date;
			}
			@Override
			public int compareTo(Node o) {
				if(this.supply > o.supply) {
					return -1;
				}else if(this.supply < o.supply) {
					return 1;
				}
				return Integer.compare(this.date, o.date);
			}
		}
	    public int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        int currentDate = 0;
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        for(int i = 0; i < dates.length; ++i) {
	        	pq.add(new Node(supplies[i], dates[i]));
	        }
	        while(true) {
	        	currentDate += stock;
	        	stock = 0;
	        	if(currentDate >= k) {
	        		break;
	        	}
	        	ArrayList<Node> tempArr = new ArrayList<>();
	        	while(!pq.isEmpty()) {
	        		Node temp = pq.poll();
	        		if(temp.date <= currentDate){
	        			stock += temp.supply;
	        			answer++;
	        			break;
	        		}else {
	        			tempArr.add(temp);
	        		}
	        	}
	        	for(Node node : tempArr) {
	        		pq.add(node);
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		Solution sol = new Solution();
		System.out.println(sol.solution(stock, dates, supplies, k));
	}
}
