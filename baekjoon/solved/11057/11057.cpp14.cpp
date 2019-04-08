#include <iostream>
using namespace std;
int main(){
    int dp_arr[2][10];
    int k = 0;
    for(int j = 0; j < 10; j++)
        dp_arr[k][j] = 1;
    int n;
    cin >> n;
    for(int i = 1; i < n; i++){
        k = !k;
        for(int j = 0; j < 10; j++){
        	dp_arr[k][j] = 0;
            for(int l = 0; l <= j; l++){
                dp_arr[k][j] += dp_arr[!k][l];
                dp_arr[k][j] %= 10007;
            }
        }
    }
    int result = 0;
    for(int j = 0; j < 10; j++){
        result += dp_arr[k][j];
        result %= 10007;
    }
    cout << result;
    return 0;
}