#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main() {
	int t;
	cin >> t;
	while(t--){
		int n;
		cin >> n;
		vector<vector<int>> nodes(n+1);
		for(int from = 1; from <= n; ++from){
			int to;
			cin >> to;
			nodes[from].push_back(to);
		}
		int count = 0;
		vector<bool> visited(n+1,false);
		queue<int> node_queue;
		for(int start_index = 1; start_index <= n; ++start_index){
			if(visited[start_index] == false){
				count++;
				node_queue.push(start_index);
				int current;
				while(!node_queue.empty()){
					current = node_queue.front();
					node_queue.pop();
					if(visited[current] == false){
						visited[current] = true;
						for(int i = 0; i < nodes[current].size(); ++i){
							node_queue.push(nodes[current][i]);
						}
					}
				}
			}
		}
		cout << count << "\n";
	}
	return 0;
}