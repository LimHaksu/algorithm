#include <iostream>
#include <vector>
#include <set>
#include <map>
using namespace std;
int pow(int n,int p){
	int result = 1;
	for(int i = 0; i < p; ++i){
		result *= n;
	}
	return result;
}
int make_next_num(int n, int p){
	vector<int> arr;
	while(n>0){
		arr.push_back(n%10);
		n /= 10;
	}
	int sum = 0;
	for(int i = 0; i < arr.size(); ++i){
		sum += pow(arr[i],p);
	}
	return sum;
}
int main(){
	int n, p, next;
	cin >> n >> p;
	int index = 0, answer;
	next = n;
	set<int> numbers;
	map<int,int> number_index;
	numbers.insert(n);
	number_index[n] = 0;
	int count = 0;
	while(true){
		next = make_next_num(next, p);
		if(numbers.find(next) != numbers.end()){
			answer = number_index[next];
			break;
		}
		numbers.insert(next);
		number_index[next] = ++count;
	}
	cout << answer;
	return 0;
}