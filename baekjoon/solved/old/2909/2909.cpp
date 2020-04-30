#include <iostream>
using namespace std;
int main(){
    int c, k;
    cin >> c >> k;
    for(int i = 0; i < k-1; ++i){
        c /= 10;
    }
    if(c%10 >= 5)
        c+=10;
    c/=10;
    for(int i = 0; i < k; ++i){
        c *= 10;
    }
    cout << c;
    return 0;
}