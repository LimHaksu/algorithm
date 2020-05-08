#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> arr(n);
	vector<int> dp(n);
	for(int i = 0; i < n; ++i){
		cin >> arr[i];
	}
	dp[0] = arr[0];
	for(int i = 1; i < n; ++i){
		int max = arr[i];
		for(int j = 0; j < i; ++j){
			max = max > dp[j] + dp[i-1-j] ? max : dp[j] + dp[i-1-j];
		}
		dp[i] = max;
	}
	cout << dp[n-1];
	return 0;
}