#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    vector<int> arr(9);
    for(int i = 0; i < 9; i++){
        cin >> arr[i];
    }
    int sum = 0;
    for(int i = 0; i < 7; i++){
        sum += arr[i];
    }
    while(sum != 100){
        sum = 0;
        next_permutation(arr.begin(), arr.end());
        for(int i = 0; i < 7; i++){
            sum += arr[i];
        }
    }
    sort(arr.begin(), arr.begin()+7);
    for(int i = 0; i < 7 ;i++){
        cout << arr[i] << "\n";
    }
    return 0;
}