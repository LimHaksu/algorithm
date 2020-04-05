//test set 1 ok, test set 2 TLE
// visited == false면서 문제 4 조건 만족하면 dfs
#include <iostream>
#include <vector>
#include <cstdio>
#include <utility>
using namespace std;
typedef vector<vector<bool>> vvb;
typedef vector<bool> vb;
bool check(int r, int c, int i, int j){
    if(r == i || c == j || r-c == i-j || r+c == i+j)
        return false;
    return true;
}
void dfs(vvb& visited,int r, int c,int count, vector<pair<int,int>>& q, bool& possible, int test){
    // 이미 체크하고 들어온 상태
    if(count == visited.size()*visited[0].size()){
        cout << "Case #" << test << ": POSSIBLE\n";
        for(int i = 0; i < q.size(); ++i){
            cout << q[i].first+1 << ' ' << q[i].second+1 << '\n';
        }
        possible = true;
        return;
    }
    for(int i = 0; i < visited.size(); ++i){
        for(int j = 0; j < visited[i].size(); ++j){
            if(check(r,c,i,j) && !visited[i][j] && !possible){
                visited[i][j] = true;
                q.push_back(make_pair(i,j));
                dfs(visited,i,j,count+1,q, possible, test);
                visited[i][j] = false;
                q.pop_back();
            }
        }
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int t;
    cin >> t;
    for(int test = 1; test <= t; ++test){
        int r, c;
        cin >> r >> c;
        vvb visited(r,vb(c,false));
        bool possible = false;
        int count = 0;
        vector<pair<int,int>> q;
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                dfs(visited,i,j,count,q, possible, test);
            }
        }
        if(!possible)
            cout << "Case #" << test << ": IMPOSSIBLE\n";
    }

    return 0;
}