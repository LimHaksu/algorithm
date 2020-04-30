#include <iostream>
#include <vector>
using namespace std;

int main() {
	int t;
	cin >> t;
	vector<bool> arr(1000001,true);
	arr[0] = false; arr[1] = false;		
	for(int i = 2; i <=1000000; ++i){
		if(arr[i] == true){
			for(int j = 2*i; j <= 1000000; j += i){
				arr[j] = false;
			}
		}
	}
	while(t--){
		int n;
		cin >> n;
		int count = 0;
		for(int i = 2; i <= n/2; ++i){
			if(arr[i] == true && arr[n-i] == true){
				count++;
			}
		}
		cout << count << "\n";
	}
	return 0;
}