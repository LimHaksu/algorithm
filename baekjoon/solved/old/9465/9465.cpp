#include <iostream>
#include <vector>
#include <cstdio>

using namespace std;
int max(int a, int b){
    return a > b ? a : b;
}
int max(int a, int b, int c){
    a = a > b ? a : b;
    return a > c ? a : c;
}
int main(){
    freopen("input.txt","r",stdin);
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<vector<int>> arr(2,vector<int>(n));
        for(int i = 0; i < 2; ++i){
            for(int j = 0; j < n; ++j){
                cin >> arr[i][j];
            }
        }
        vector<vector<int>> dp(2,vector<int>(n));
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[1][0]+arr[0][1];
        dp[1][1] = arr[0][0]+arr[1][1];
        for(int j = 2; j < n; ++j){
            for(int i = 0; i < 2; ++i){
                dp[i][j] = max(max(dp[0][j-2],dp[1][j-2])+arr[i][j],dp[!i][j-1]+arr[i][j], dp[i][j-1]);
            }
        }
        cout << max(dp[0][n-1],dp[1][n-1]) << "\n";
    }
    return 0;
}