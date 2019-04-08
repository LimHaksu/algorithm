#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    int k = 1;
    for(; k*k <= n; k++){
        if(k*k+k+1 == n)
            break;
    }
    cout << k;
    return 0;
}