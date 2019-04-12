#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdio>
using namespace std;
int main(){
    freopen("input.txt","r",stdin);
    ios_base::sync_with_stdio(false);cin.tie(0);
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; ++i){
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());
    vector<int> dp(n); // 기다리는 시간
    dp[0] = 0;
    for(int i = 1; i < n; ++i){
        dp[i] = dp[i-1] + arr[i-1];
    }
    int sum = 0;
    for(int i = 0; i < n; ++i){
        sum += arr[i]+dp[i];
    }
    cout << sum;
    return 0;
}