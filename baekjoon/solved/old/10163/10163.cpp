#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
int main(){
    freopen("input.txt", "r", stdin);
    int n;
    cin >> n;
    vector<vector<int>> arr(102,vector<int>(102,0));
    int r_start, c_start, r_size, c_size;
    for(int i = 1; i <= n; ++i){
        cin >> r_start >> c_start >> r_size >> c_size;
        for(int j = r_start; j < r_start+r_size; ++j){
            for(int k = c_start; k < c_start+c_size; ++k){
                arr[j][k] = i;
            }
        }
    }
    vector<int> count(n+1,0);
    for(int i = 0; i < 102; ++i){
        for(int j = 0; j < 102; ++j){
            count[arr[i][j]]++;
        }
    }
    for(int i = 1; i <= n; ++i){
        cout << count[i] << '\n';
    }
    return 0;
}