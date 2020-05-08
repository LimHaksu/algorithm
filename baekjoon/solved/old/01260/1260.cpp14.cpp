#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
using namespace std;
#define MAX 1001
bool visit[MAX];
vector<int> adj[MAX];
queue<int> q;
stack<int> s;
void DFS(int x)
{
    s.push(x);
    while(!s.empty()){
        int xprime = s.top();
        s.pop();
        if(!visit[xprime]){
	        cout << xprime << " ";
	    	visit[xprime] = true;
	        for(int y : adj[xprime]){
	            if(!visit[y]){
	                s.push(y);
	            }
	        }
        }
    }
}
void BFS(int x){
    q.push(x);
    visit[x] = false;
    while(!q.empty()){
        int xprime = q.front();
        q.pop();
        cout << xprime << " ";
        for(int y : adj[xprime]){
            if(visit[y]){
                q.push(y);
                visit[y] = false;
            }
        }
    }
}
int main(){
    int n, m, v;
    cin >> n >> m >> v;
    for(int i = 0; i < m; ++i){
        int f, t;
        cin >> f >> t;
        adj[f].push_back(t);
        adj[t].push_back(f);
    }
    for(int i = 1; i <= n; ++i){
        sort(adj[i].begin(), adj[i].end(), greater<int>());
    }
    DFS(v);
    cout << "\n";
    for(int i = 1; i <= n; ++i){
        sort(adj[i].begin(), adj[i].end());
    }
    BFS(v);
}