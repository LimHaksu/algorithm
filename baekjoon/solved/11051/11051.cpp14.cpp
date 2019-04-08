#include <iostream>
using namespace std;
int combination(int n,int k, int c[][1001]){
    if(k==0 || n==k){
        return 1;
    }
    if(c[n-1][k-1] == 0){
        c[n-1][k-1] = combination(n-1, k-1, c);
    }
    if(c[n-1][k] == 0){
        c[n-1][k] = combination(n-1, k, c);
    }
    return (c[n-1][k-1] + c[n-1][k]) % 10007;
}
int main(void){
    int n, k;
    cin >> n >> k;
    int c[1001][1001] = {0, };
    cout << combination(n, k, c);
    return 0;
}