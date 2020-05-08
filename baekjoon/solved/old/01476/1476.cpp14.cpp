#include <iostream>
using namespace std;
int main(){
    int e, s, m;
    cin >> e >> s >> m;
    int n = 1;
    while(true){
        if( ((n-1) % 15)+1 == e && ((n-1) % 28)+1 == s && ((n-1) % 19) + 1 == m){
            cout << n;
            break;
        }
        n++;
    }
    return 0;
}