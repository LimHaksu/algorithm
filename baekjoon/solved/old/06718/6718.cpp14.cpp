#include <cstdio>
#include <vector>
using namespace std;

int main() {
	vector<bool> arr(1000001,true);
	vector<int> prime(1000001);
	arr[0] = false; arr[1] = false;		
	for(int i = 2; i <=1000000; ++i){
		if(arr[i] == true){
			prime.push_back(i);
			for(int j = 2*i; j <= 1000000; j += i){
				arr[j] = false;
			}
		}
	}
	while(true){
		int n;
		scanf("%d\n", &n);
		if(n== 0){
			break;
		}
		int count = 0;
		for(int i = 0; i < prime.size() && prime[i] <= n/2; i++){
			if(arr[prime[i]] == true && arr[n-prime[i]] == true){
				count++;
			}
		}
		printf("%d\n", count);
	}
	return 0;
}