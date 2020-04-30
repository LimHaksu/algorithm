#include <iostream>
using namespace std;
int max(int a, int b){
    return a > b? a : b;
}
int main(){
    int n;
    cin >> n;
    int *dp_arr[2];
    int glass_arr[n];
    for(int j = 0; j < n; j++)
        cin >> glass_arr[j];
    for(int i = 0; i < 2; i++)
        dp_arr[i] = new int[n];
    dp_arr[0][0] = glass_arr[0];
    dp_arr[1][0] = 0;
    if(n>1){
        dp_arr[0][1] = glass_arr[0] + glass_arr[1];
        dp_arr[1][1] = dp_arr[0][0];
        for(int j = 2; j < n; j++){
            dp_arr[0][j] = max(dp_arr[0][j-2] + glass_arr[j], dp_arr[1][j-2] + glass_arr[j-1] + glass_arr[j]);
            dp_arr[1][j] = max(dp_arr[0][j-1], dp_arr[1][j-1]);
        }
    }
    cout << max(dp_arr[0][n-1], dp_arr[1][n-1]);
    for(int i = 0; i < 2; i++)
        delete[] dp_arr[i];
    return 0;
}