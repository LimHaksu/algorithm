import java.io.*;
import java.util.*;
public class boj1062 {
	static char[] carr = {'b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z'};
	static String[] strs;
	static int max = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		strs = new String[n];
		for(int i = 0; i < n; ++i) {
			strs[i] = br.readLine();
		}
		boolean[] checked = new boolean[21];
		dfs(checked, 0, 0, k-5);
		System.out.println(max);
	}
	static void dfs(boolean[] checked, int idx, int count, int k) {
		if(count == k) {
			// 선택 완료
			int countStr = 0;
			HashSet<Character> available = new HashSet<Character>();
			available.add('a');
			available.add('c');
			available.add('i');
			available.add('n');
			available.add('t');
			for(int i = 0; i < checked.length; ++i) {
				if(checked[i]) {
					available.add(carr[i]);
				}
			}
			for(int i = 0; i < strs.length; ++i) {
				boolean strCheck = true;
				for(int j = 0; j < strs[i].length(); ++j) {
					if(!available.contains(strs[i].charAt(j))) {
						strCheck = false;
						break;
					}
				}
				if(strCheck) {
					countStr++;
				}
			}
			if(countStr > max) {
				max = countStr;
			}
			return;
		}
		if(idx == checked.length) {
			return;
		}
		checked[idx] = true;
		dfs(checked, idx+1, count+1, k);
		checked[idx] = false;
		dfs(checked, idx+1, count, k);
	}
}
