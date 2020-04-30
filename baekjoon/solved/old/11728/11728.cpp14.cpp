#include <iostream>
#include <vector>
using namespace std;
 
int main() {
	int n, m;
	cin >> n >> m;
	vector<int> arr1(n);
	vector<int> arr2(m);
	vector<int> merge;
	merge.reserve(n+m);
	for(int i = 0; i < n; ++i){
		cin >> arr1[i];
	}
	for(int i = 0; i < m; ++i){
		cin >> arr2[i];
	}
	int id1 = 0, id2 = 0;
	while(id1 < n || id2 < m){
		if(id1 == n){
			while(id2 < m){
				merge.push_back(arr2[id2++]);
			}
		}else if(id2 == m){
			while(id1 < n){
				merge.push_back(arr1[id1++]);
			}
		}else{
			if(arr1[id1] < arr2[id2]){
				merge.push_back(arr1[id1]);
				id1++;
			}else{
				merge.push_back(arr2[id2]);
				id2++;
			}
		}
	}
	for(int i = 0; i < merge.size(); ++i){
		cout << merge[i] << ' ';
	}
	return 0;
}