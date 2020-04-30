#include <iostream>
#include <stack>
using namespace std;

int main(){
    int n;
    cin >> n;
    int ans = 0;
    int *arr = new int[n];
    int *dp = new int[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    for(int i = 0; i < n; i++){
        int max = 0;
        for(int j = 0; j < i; j++){
            if(arr[j] < arr[i] && dp[j] > max)
                max = dp[j];
        }
        dp[i] = max +1;
        if(dp[i]> ans)
            ans = dp[i];
    }
    cout << ans << endl;
    int max = ans;
    stack<int> st;
    for(int i = n-1; i >= 0; i--){
        if(max == dp[i]){
            st.push(arr[i]);
            max--;
        }
        if(max < 1)
            break;
    }
    while(st.size() > 0){
        cout << st.top() << " ";
        st.pop();
    }
    return 0;
}