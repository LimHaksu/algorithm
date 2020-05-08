#include <iostream>
#include <vector>
using namespace std;
// 1 1 1 2 2 3 4 5 7 9
int main() {
	int t,n;
    vector<long long> arr(100);
    arr[0] = 1; arr[1] = 1; arr[2] = 1; arr[3] = 2; arr[4] = 2;
    for(int i = 5; i < 100; i++){
        arr[i] = arr[i-5] + arr[i-1];
    }
    cin >> t;
	for(int j = 0; j < t; j++){
		cin >> n;
        cout << arr[n-1] << "\n";
	}
	return 0;
}