#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    unsigned int arr[2][10];
    arr[0][0] = 0;
    for(int i = 1; i < 10; i++){
        arr[0][i] = 1;
    }
    for(int i = 0; i < 10; i++){
        arr[1][i] = 0;
    }
    int j = 0;
    for(int i = 1; i < n; i++){
        j = !j;
        arr[j][0] = arr[!j][1] % 1000000000;
        for(int k = 1; k < 9; ++k){
            arr[j][k] = (arr[!j][k-1] + arr[!j][k+1]) % 1000000000;
        }
        arr[j][9] = arr[!j][8] % 1000000000;
    }
    int answer = 0;
    for(int i = 0; i < 10; i++){
        answer = (answer + arr[j][i]) % 1000000000;
    }
    cout << answer;
    return 0;    
}