#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    int n;
    cin >> n;
    vector<long long> arr(n);
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end());
    int count = 1;
    int max_count = 1;
    long long max_count_num = arr[0];
    for(int i = 1; i < n; i++){
        if(arr[i] == arr[i-1]){
            count++;
        }else{
            count = 1;
        }           
        if(count > max_count){
            max_count = count;
            max_count_num = arr[i]; 
        }
    }
    cout << max_count_num;
    return 0;
}