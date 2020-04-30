#include <cstdio>
#include <vector>
#include <utility>
using namespace std;

int main() {
	int t;
	scanf("%d", &t);
	vector<bool> arr(32001,true);
	vector<int> prime(32001);
	arr[0] = false; arr[1] = false;		
	for(int i = 2; i <=32000; ++i){
		if(arr[i] == true){
			prime.push_back(i);
			for(int j = 2*i; j <= 32000; j += i){
				arr[j] = false;
			}
		}
	}
	while(t--){
		int n;
		scanf("%d", &n);
		int count = 0;
		vector<pair<int,int>> list;
		for(int i = 0; i < prime.size() && prime[i] <= n/2; i++){
			if(arr[prime[i]] == true && arr[n-prime[i]] == true){
				count++;
				list.push_back(pair<int,int>(prime[i],n-prime[i]));
			}
		}
		printf("%d has %d representation(s)\n", n,count);
		for(int i = 0; i < list.size(); i++){
			printf("%d+%d\n",list[i].first, list[i].second);
		}
		printf("\n");
	}
	return 0;
}