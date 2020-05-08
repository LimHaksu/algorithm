import java.io.*;
import java.util.*;
// 추가시간이 없어서 java는 시간초과 실제 통과한 코드는 c++
/*
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;

bool compare(vi& a, vi&b){
	if(a[1] < b[1]){
		return true;
	}else if(a[1] > b[1]){
		return false;
	}
	return a[0] < b[0];
}

int find_idx(int start_time, vvi& arr){
	int left = 0;
	int right = arr.size()-1;
	int result = -1;
	while(left <= right){
		int mid = (left+right) /2;
		int end_time = arr[mid][1];
		if(end_time  < start_time){
			result = mid;
			left = mid+1;
		}else{
			right = mid-1;
		}
	}
	return result;
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0);
	int n;
	cin >> n;
	vvi arr(n, vi(3));
	for(int i = 0; i < n; ++i){
		for(int j = 0; j < 3; ++j){
			cin >> arr[i][j];
		}
	}
	vi dp(n);
	sort(arr.begin(), arr.end(), compare);
	dp[0] = arr[0][2];
	
	for(int i = 1; i < n; ++i){
		if(arr[i][0] <= arr[i-1][1]){
			int idx = find_idx(arr[i][0], arr);
			if(idx != -1){
				dp[i] = max(dp[idx]+ arr[i][2], dp[i-1]);
				
			}else{
				dp[i] = max(arr[i][2], dp[i-1]);
			}
		}else{
			dp[i] = dp[i-1] + arr[i][2];
		}
	}
	cout << dp[n-1];
	return 0;
}
*/
public class boj17099 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			for(int j = 0; j < 3; ++j) { 
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dp = new int[n];
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] < o2[1]) {
					return -1;
				}else if(o1[1] > o2[1]) {
					return 1;
				}
				return o1[0]-o2[0];
			}
		});
		dp[0] = arr[0][2];
		for(int i = 1; i < n; ++i) {
			if(arr[i][0] <= arr[i-1][1]) {
				int idx = findIdx(arr[i][0], arr);
				if(idx != -1) {
					dp[i] = Math.max(dp[idx]+ arr[i][2], dp[i-1]);
				}else {
					dp[i] = Math.max(arr[i][2], dp[i-1]);
				}
			}else {
				dp[i] = dp[i-1] + arr[i][2];
			}
		}
		System.out.println(dp[n-1]);
	}
	static int findIdx(int startTime, int[][] arr) {
		int left = 0;
		int right = arr.length-1;
		int result = -1;
		while(left <= right) {
			int mid = (left+right)/2;
			int endTime = arr[mid][1];
			if(endTime < startTime) {
				result = mid;
				left = mid+1;
			}else {
				right = mid -1;
			}
		}
		return result;
	}
}


