#include <iostream>
#include <vector>
#include <cstdio> // freopen()
using namespace std;

void dfs(vector<vector<int>>& ground, vector<vector<bool>>&visited, int r, int c){
    if(r<0 || r>= ground.size() || c < 0 || c >= ground[0].size()){
        return;
    }
    if(visited[r][c] || !ground[r][c])
        return;
    visited[r][c] = true;
    dfs(ground,visited,r-1,c);
    dfs(ground,visited,r+1,c);
    dfs(ground,visited,r,c-1);
    dfs(ground,visited,r,c+1);
}
int main(){
    freopen("input.txt" , "r", stdin);
    int t;
    cin >> t;
    while(t--){
        int m, n, k;
        cin >> m >> n >> k;
        vector<vector<int>> ground(n,vector<int>(m,0));
        vector<vector<bool>> visited(n, vector<bool>(m,false));
        int r, c;
        for(int i = 0 ; i < k; ++i){
            cin >> c >> r;
            ground[r][c] = 1;
        }
        int count = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(!visited[i][j] && ground[i][j]){
                    dfs(ground,visited,i,j);
                    count++;
                }
            }
        }
        cout << count << '\n';
    }
    return 0;
}