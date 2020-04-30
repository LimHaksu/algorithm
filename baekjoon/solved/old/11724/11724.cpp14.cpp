#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int main(){
    int n, m;
    cin >> n >> m;
    vector<vector<int>> nodes(n+1);
    vector<int> visited(n+1,false);
    int from, to;
    for(int i = 0; i < m; ++i){
        cin >> from >> to;
        nodes[from].push_back(to);
        nodes[to].push_back(from);
    }
    stack<int> node_stack;
    int count = 0;
    for(int i = 1; i <= n; ++i){
        if(visited[i] == false){
            count++;
            node_stack.push(i);
            while(!node_stack.empty()){
                int current = node_stack.top();
                node_stack.pop();
                if(visited[current] == false){
                    visited[current] = true;
                    for(int i = 0; i < nodes[current].size(); ++i){
                        node_stack.push(nodes[current][i]);
                    }
                }
            }
        }
    }
    cout << count;
    return 0;
}