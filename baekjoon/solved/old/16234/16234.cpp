#include <iostream>
#include <vector>
#include <utility>
#include <cstdio>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
typedef pair<int,int> pii;
int dr[4] = {0,0,-1,1};
int dc[4] = {-1,1,0,0};
bool check(vvi& nation, int l, int r, int fr, int fc, int sr, int sc){
    if(sr < 0 || sr >= nation.size() || sc < 0 || sc >= nation.size()){
        return false;
    }
    int diff = nation[fr][fc] - nation[sr][sc];
    diff = diff < 0 ? -diff : diff;
    if(diff >= l && diff <= r)
        return true;
    else
        return false;    
}
void dfs(vvi& nation, vvi& visited,vector<pii>& q, int l, int r, int cr, int cc){
    q.push_back(make_pair(cr,cc));
    visited[cr][cc] = true;
    for(int i = 0; i < 4; ++i){
        if(check(nation,l,r,cr,cc,cr+dr[i],cc+dc[i])){
            if(!visited[cr+dr[i]][cc+dc[i]]){
                dfs(nation,visited,q,l,r,cr+dr[i],cc+dc[i]);
            }
        }
    }
}
void one_union_redistribuion(vvi&nation, vector<pii>& q){
    int sum = 0;
    for(int i = 0; i < q.size(); ++i){
        sum += nation[q[i].first][q[i].second];
    }
    int one = sum / q.size();
    for(int i = 0; i < q.size(); ++i){
        nation[q[i].first][q[i].second] = one;
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n, l, r;
    cin >> n >> l >> r;
    vvi nation(n,vi(n));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> nation[i][j];
        }
    }
    int union_size;
    int count = 0;
    do{
        vvi visited(n,vi(n,false));
        vector<vector<pii>> nation_union;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(!visited[i][j]){
                    vector<pii> q;
                    dfs(nation,visited,q,l,r,i,j);
                    if(q.size() > 0){
                        nation_union.push_back(q);
                    }
                }
            }
        }
        union_size = nation_union.size();
        if(union_size != n*n){
            count++;
            for(int i = 0; i < nation_union.size(); ++i){
                one_union_redistribuion(nation,nation_union[i]);
            }
        }
    }while(n*n != union_size);
    cout << count;
    return 0;
}