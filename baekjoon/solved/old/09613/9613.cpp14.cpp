#include <iostream>
using namespace std;
int gcd(int a, int b){
    int min = a < b ? a : b;
    int max = a > b ? a : b;
    int remain = 1;
    while(remain != 0){
        remain = max % min;
        max = min;
        min = remain;
    }
    return max;
}
int main(){
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        int* arr = new int[n];
        for(int i = 0; i < n; i++){
            cin >> arr[i];
        }
        long long sum = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                sum += gcd(arr[i],arr[j]);
            }
        }
        cout << sum << "\n";
        delete[] arr;
    }
    return 0;
}