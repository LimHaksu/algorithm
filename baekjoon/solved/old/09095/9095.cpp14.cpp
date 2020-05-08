#include <iostream>
using namespace std;
int main(){
    int T;
    cin >> T;
    int dp_arr[10];
    dp_arr[0] = 1;
    dp_arr[1] = 2;
    dp_arr[2] = 4;
    while(T--){
        int n;        
        cin >> n;
        for(int i = 3; i < n; i++){
            dp_arr[i] = dp_arr[i-3] + dp_arr[i-2] + dp_arr[i-1];
        }
        cout << dp_arr[n-1] << endl;
    }
    return 0;
}