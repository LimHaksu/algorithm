import java.util.*;
class Solution {
    public int[] solution(String s) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	String[] arr = s.split("[{}]");
        String[] arr2 = new String[arr.length/2];
        for(int i = 2; i < arr.length; i+=2) {
        	arr2[i/2-1] = arr[i];
        }
        Arrays.sort(arr2,new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		if(o1.length() < o2.length()) {
        			return -1;
        		}else if(o1.length() > o2.length()){
        			return 1;
        		}
        		return 0;
        	}
		});
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < arr2.length; ++i) {
        	String[] temp = arr2[i].split(",");
        	for(int j = 0; j < temp.length; ++j) {
        		int num = Integer.parseInt(temp[j]);
        		if(!set.contains(num)) {
        			ans.add(num);
        			set.add(num);
        			break;
        		}
        	}
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i) {
        	answer[i] = ans.get(i);
        }
        return answer;
    }
}
public class 튜플 {
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(s)));
	}
}
