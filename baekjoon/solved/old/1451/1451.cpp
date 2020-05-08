#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
using namespace std;
long long MAX(long a, long b){
    return a > b ? a : b;
}
long long sum(vector<vector<int>>& arr, int rs, int cs, int rf, int cf){
    long long total = 0; 
    for(int i = rs; i < rf; ++i){
        for(int j = cs; j < cf; ++j){
            total += arr[i][j];
        }
    }
    return total;
}
int main(){
    freopen("input.txt","r",stdin);
    int n, m;
    cin >> n >> m;
    string line;
    vector<vector<int>> arr(n,vector<int>(m));
    for(int i = 0; i < n; ++i){
        cin >> line;
        for(int j = 0; j < m; ++j){
            arr[i][j] = line[j]-'0';
        }
    }
    long long max = 0;
    for(int i = 1; i < n; ++i){
        for(int j = 1; j < m; ++j){
            max = MAX(max , sum(arr,0,0,i,j)*sum(arr,0,j,i,m)*sum(arr,i,0,n,m));
            max = MAX(max , sum(arr,0,0,i,j)*sum(arr,i,0,n,j)*sum(arr,0,j,n,m));
            max = MAX(max , sum(arr,0,0,i,m)*sum(arr,i,0,n,j)*sum(arr,i,j,n,m));
            max = MAX(max , sum(arr,0,j,i,m)*sum(arr,0,0,n,j)*sum(arr,i,j,n,m));
        }
    }
    for(int i = 1; i < n-1; ++i){
        for(int j = i+1; j<n; ++j){
            max = MAX(max , sum(arr,0,0,i,m)*sum(arr,i,0,j,m)*sum(arr,j,0,n,m));
        }
    }
    for(int i = 1; i < m-1; ++i){
        for(int j = i+1; j < m; ++j){
            max = MAX(max , sum(arr,0,0,n,i)*sum(arr,0,i,n,j)*sum(arr,0,j,n,m));
        }
    }
    cout << max;
    return 0;
}