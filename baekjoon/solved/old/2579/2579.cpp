#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
int MAX(int a, int b){
    if(a > b)
        return a;
    return b;
}
int main(){
    ios_base::sync_with_stdio(false);cin.tie(0);
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; ++i){
        cin >> arr[i];
    }
    vector<int> dp(n);
    dp[0] = arr[0];
    if(n>1){
        dp[1] = arr[0]+arr[1];
        dp[2] = MAX(arr[0]+arr[2],arr[1]+arr[2]);
        for(int i = 3; i < n; ++i){
            dp[i] = MAX(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
        }
    }
    cout << dp[n-1];
    return 0;
}