#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    for(int j = 0; j < n-1; j++)
        cout << " ";
    cout << "*" << endl;
    for(int i = 0; i < n-2; i++){
        for(int j = 0; j < n-i-2; j++)
            cout << " ";
        cout << "*";
        for(int j = 0; j < 2*i+1; j++)
            cout << " ";
        cout << "*";
        cout << endl;
    }
    if(n>1)
    for(int j = 0; j < 2*n-1; j++){
        cout << "*";
    }
    return 0;
}