#include <iostream>
#include <vector>
#include <map>
#include <cstdio>
using namespace std;
int main(){
    freopen("input.txt","r",stdin);
    int t, n, m;
    cin >> t >> n;
    vector<int> a(n);
    for(int i = 0; i < n; ++i){
        cin >> a[i];
    }
    cin >> m;
    vector<int> b(m);
    for(int i = 0; i < m; ++i){
        cin >> b[i];
    }
    map<int,long long> amap, bmap;
    for(int i = 0; i < n; ++i){
        int asum = 0;
        for(int j = i; j < n; ++j){
            asum += a[j];
            amap[asum]++;
        }
    }
    for(int i = 0; i < m; ++i){
        int bsum = 0;
        for(int j = i; j < m; ++j){
            bsum += b[j];
            bmap[bsum]++;
        }
    }
    long long count = 0;
    for(map<int,long long>::iterator it = amap.begin(); it != amap.end(); ++it){
        if(bmap.find(t-it->first) != bmap.end()){
            count += it->second * bmap[t-it->first];
        }
    }
    cout << count;
    return 0;
}