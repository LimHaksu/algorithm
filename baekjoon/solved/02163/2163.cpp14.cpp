#include <iostream>
using namespace std;

int main(){
    int n, m;
    int row = 1, col = 1;
    cin >> n >> m;
    int result = 0;
    for(; row < n; row++){
       result += col;
    }
    for( ; col < m; col++){
        result += row;
    }
    cout << result;
    return 0;
}