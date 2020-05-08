#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	string op;
	vector<int> q;
	int operand;
	for(int i = 0; i < n; ++i){
		cin >> op;
		if(op == "push"){
			cin >> operand;
			q.push_back(operand);
		}else if(op == "pop"){
			if(q.size() > 0){
				cout << q[0] << '\n';
				q.erase(q.begin());
			}else{
				cout << -1 << '\n';
			}
		}else if(op == "size"){
			cout << q.size() << '\n';
		}else if(op == "empty"){
			cout << (int)q.empty() << '\n';
		}else if(op == "front"){
			if(q.size() > 0){
				cout << q[0] << '\n';
			}else{
				cout << -1 << '\n';
			}
		}else if(op == "back"){
			if(q.size() > 0){
				cout << q[q.size()-1] << '\n';
			}else{
				cout << -1 << '\n';
			}
		}
	}
	return 0;
}