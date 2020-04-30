#include <iostream>
#include <vector>
#include <utility>
#include <cstdio>
#include <map>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
typedef pair<int,int> pii;
int distance(pii home, vector<pii>&  s_chicken){
    int dx,dy;
    int min = 100;
    for(int i = 0; i < s_chicken.size(); ++i){
        dx = s_chicken[i].first > home.first ? s_chicken[i].first - home.first : home.first - s_chicken[i].first;
        dy = s_chicken[i].second > home.second ? s_chicken[i].second - home.second : home.second - s_chicken[i].second;
        if(min > dx+dy)
            min = dx+dy;
    }
    return min;
}
void dfs(vvi& mymap, vector<pii>& chicken, vector<bool>& selected, vector<pii>& home, int index, int count, int& m, int& min){
    if(count == m){
        vector<pii> s_chicken;
        for(int i = 0; i < chicken.size(); ++i){
            if(selected[i]){
                s_chicken.push_back(chicken[i]);
            }
        }
        int sum = 0;
        for(int i = 0; i < home.size(); ++i){
            sum += distance(home[i],s_chicken);
        }
        if(sum < min)
            min = sum;
        return;
    }
    for(int i = index; i < chicken.size(); ++i){
        if(!selected[i]){
            selected[i] = true;
            dfs(mymap,chicken,selected,home,i+1,count+1,m,min);
            selected[i] = false;
        }
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n , m;
    cin >> n >> m;
    vvi mymap(n,vi(n));
    vector<pii> chicken;
    vector<pii> home;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> mymap[i][j];
            if(mymap[i][j] == 1)
                home.push_back(make_pair(i,j));
            else if(mymap[i][j] == 2)
                chicken.push_back(make_pair(i,j));
        }
    }
    vector<bool> selected(chicken.size(),false);
    int min = 100*m*home.size();
    dfs(mymap,chicken,selected,home,0,0,m,min);
    cout << min;
    return 0;
}