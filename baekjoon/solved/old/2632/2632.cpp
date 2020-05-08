#include <iostream>
#include <vector>
#include <map>
#include <cstdio>
using namespace std;
int main(){
    freopen("input.txt","r",stdin);
    int w, m, n;
    cin >> w >> m >> n;
    vector<int> a(m);
    map<int,long long> amap;
    int asum = 0;
    for(int i = 0; i < m ; ++i){
        cin >> a[i];
        asum += a[i];
    }
    amap[asum]++;
    vector<int> b(n);
    map<int,long long> bmap;
    int bsum = 0;
    for(int i = 0; i < n; ++i){
        cin >> b[i];
        bsum += b[i];
    }
    bmap[bsum]++;
    for(int i = 0; i < m; ++i){
        asum = 0;
        for(int j = i; j < m+i-1; ++j){
            asum += a[j%m];
            amap[asum]++;
        }
    }    
    for(int i = 0; i < n; ++i){
        bsum = 0;
        for(int j = i; j < n+i-1; ++j){
            bsum += b[j%n];
            bmap[bsum]++;
        }
    }
    long long count = 0;
    for(auto e : amap){
        if(e.first == w){
            count += e.second;
        }else if(bmap.find(w-e.first) != bmap.end()){
            count += e.second * bmap[w-e.first];
        }
    }
    for(auto e : bmap){
        if(e.first == w){
            count += e.second;
        }
    }
    cout << count;
    return 0;
}