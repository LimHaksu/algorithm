#include <iostream>
using namespace std;

int main(void){
    int n, k;
    cin >> n >> k;
    int count = 0;
    int p = 1;
    for(int i = 0; i < k; i++){
        p *= (n-i);
    }
    for(int i = 1; i < k+1; i++){
        p /= i;
    }
    cout << p;
    return 0;
}