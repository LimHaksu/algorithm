#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            i+j < n-1 ? cout << " " : cout << "*";
        }
        cout << endl;
    }
    for(int i = 0; i < n-1; i++){
        for(int j = 0; j < n; j++)
            j <= i ? cout << " " : cout << "*";
        cout << endl;
    }
    return 0;
}