#include <iostream>
#include <vector>
using namespace std;
const int mod = 1000000000;
int main() {
	int n, k;
	cin >> n >> k;
	vector<vector<int>> arr(2,vector<int>(n+1));
	for(int i = 0; i <= n; ++i){
		arr[0][i] = 1;	
	}
	int index = 0;
	for(int i = 1; i < k; ++i){
		index = !index;
		for(int j = 0; j <= n; ++j){
			int sum = 0;
			for(int m = 0; m <= j; ++m){
				sum = (sum + arr[!index][m]) % mod;
			}
			arr[index][j] = sum;
		}
	}
	cout << arr[index][n];
	return 0;
}