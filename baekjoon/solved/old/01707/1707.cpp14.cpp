#include <iostream>
#include <vector>
#include <stack>
#include <set>
using namespace std;

int main() {
	int t;
	cin >> t;
	while(t--){
		int v, e;
		cin >> v >> e;
		vector<vector<int>> nodes(v+1);
		int from, to;
		for(int i = 0; i < e; ++i){
			cin >> from >> to;
			nodes[from].push_back(to);
			nodes[to].push_back(from);
		}
		vector<bool> visited(v+1,false);
		vector<int> node_group(v+1);
		vector<set<int>> groups(2);
		int current, group_index;
		stack<int> node_stack;
		for(int node_index = 1; node_index <= v; ++node_index){
            if(visited[node_index] == false){
                node_stack.push(node_index);
                node_group[node_index] = 0;
                groups[0].insert(node_index);
                while(!node_stack.empty()){
                    current = node_stack.top();
                    node_stack.pop();
                    if(visited[current] == false){
                        group_index = !node_group[current];
                        visited[current] = true;
                        for(int j = 0; j < nodes[current].size(); ++j){
                            node_stack.push(nodes[current][j]);
                            node_group[nodes[current][j]] = group_index;
                            groups[group_index].insert(nodes[current][j]);
                        }
                    }
                }
            }
        }
		if(groups[0].size() + groups[1].size() == v){
			cout << "YES\n";
		}else{
			cout << "NO\n";
		}
	}
	return 0;
}