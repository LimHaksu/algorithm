#include<iostream>
#include <vector>
#include<cstdio>
#include <string>
using namespace std;
typedef vector<vector<char>> vvc;
typedef vector<char> vc;
int count(vvc& arr,int r,int c){
    int min = arr.size() * arr[0].size();
    int cntb = 0, cntw = 0;
    for(int i = r; i < r+8; ++i){
        for(int j = c; j < c+8; ++j){
            if((i+j)%2 == 0 ){
                if(arr[i][j] == 'W')
                    cntb++;
                else
                    cntw++;
            }else{
                if(arr[i][j] == 'B')
                    cntb++;
                else
                    cntw++;                
            }
        }
    }
    min = min < cntb ? min : cntb;
    min = min < cntw ? min : cntw;
    return min;
}
int main(){
    freopen("input.txt","r",stdin);
    int n, m;
    cin >> n >> m;
    string line;
    vvc arr(n,vc(m));
    for(int i = 0; i < n; ++i){
        cin >> line;
        for(int j = 0; j < m; ++j){
            arr[i][j] = line[j];
        }
    }
    int min = n*m;
    int cnt;
    for(int i= 0; i <= n-8; ++i){
        for(int j = 0; j <= m-8; ++j){
            cnt = count(arr,i,j);
            min = min < cnt ? min : cnt;
        }
    }
    cout << min;
    return 0;
}