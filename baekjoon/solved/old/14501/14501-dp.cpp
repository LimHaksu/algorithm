#include <iostream>
#include <vector>

using namespace std;
int MAX(int a, int b){
    return a > b ? a : b;
}
int main(){
    int n;
    cin >> n;
    vector<int> dp(n+6,0);
    vector<int> p(n+1), t(n+1);
    for(int i = 0; i < n; ++i){
        cin >> t[i] >> p[i];
    }
    int max = 0;
    for(int i = 0; i <= n; ++i){
        dp[i] = MAX(max,dp[i]);
        dp[i+t[i]] = MAX(dp[i+t[i]],dp[i]+p[i]);
        max = MAX(dp[i],max);
    }
    cout << max;
    return 0;
}