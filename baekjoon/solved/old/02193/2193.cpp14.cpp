#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    unsigned long long int arr[2][2];
    arr[0][0] = 0;
    arr[0][1] = 1;
    int k = 0;
    for(int i = 1; i < n; i++){
        k = !k;
        arr[k][0] = arr[!k][0] + arr[!k][1];
        arr[k][1] = arr[!k][0];
    }
    cout << arr[k][0] + arr[k][1];
    return 0;
}