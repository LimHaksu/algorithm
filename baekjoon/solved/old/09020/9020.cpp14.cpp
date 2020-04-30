#include <cstdio>
#include <vector>
using namespace std;

int main() {
	int t;
	scanf("%d", &t);
	vector<bool> arr(10001,true);
	vector<int> prime(10001);
	arr[0] = false; arr[1] = false;		
	for(int i = 2; i <=10000; ++i){
		if(arr[i] == true){
			prime.push_back(i);
			for(int j = 2*i; j <= 10000; j += i){
				arr[j] = false;
			}
		}
	}
	while(t--){
		int n;
		int min, max, diff_min = 10000;
		scanf("%d", &n);
		for(int i = 0; i < prime.size() && prime[i] <= n/2; i++){
			if(arr[prime[i]] == true && arr[n-prime[i]] == true){
				if(n-2*prime[i] < diff_min){
					max = n-prime[i];
					min = prime[i];
				}
			}
		}
		printf("%d %d\n", min, max);
	}
	return 0;
}