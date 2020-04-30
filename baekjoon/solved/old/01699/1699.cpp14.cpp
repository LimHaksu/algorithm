#include <iostream>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> arr(n+1,0);
	for(int i = 1; i <= n; i++){
		arr[i] = arr[i-1]+1;
		for(int j = 2; j*j <= i; j++){
			if(arr[i] > arr[i-j*j] + 1){
				arr[i] = arr[i-j*j] + 1;
			}
		}
	}
	cout << arr[n];
	return 0;
}