#include<iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
using namespace std;
bool compare(int a, int b){
    if(a > b){
        return true;
    }
    return false;
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    vector<int> a(n);
    vector<int> b(n);
    for(int i = 0; i < n; ++i){
        cin >> a[i];
    }
    for(int i = 0; i < n; ++i){
        cin >> b[i];
    }
    sort(a.begin(),a.end());
    sort(b.begin(),b.end(),compare);
    int s=0;
    for(int i = 0; i < n; ++i){
        s += a[i]*b[i];
    }
    cout << s;
    return 0;
}