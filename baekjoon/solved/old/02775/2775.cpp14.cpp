#include <iostream>
using namespace std;

int main(void){
    int testcases;
    cin >> testcases;
    int k, n;
    for(int i = 0; i < testcases ; i++){
        cin >> k >> n;
        int arr[n];
        for(int j = 0; j < n; j++){
            arr[j] = j+1;
        }
        for(int j = 0; j < k; j++){
            for(int l = 1; l < n; l++){
                arr[l] += arr[l-1];
            }
        }
        cout << arr[n-1] << endl;
    }
    return 0;
}