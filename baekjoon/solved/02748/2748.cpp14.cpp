#include <iostream>
using namespace std;
int main(void){
    int n;
    cin >> n;
    unsigned long long int arr[2]={0,1};
    if(n==0){
        cout << arr[0];
        return 0;
    }else if(n==1){
        cout << arr[1];
        return 0;
    }
    unsigned long long int temp;
    for(int i = 1 ; i < n; i++){
        temp = arr[1];
        arr[1] += arr[0];
        arr[0] = temp;
        
    }
    cout << arr[1] << endl;
    return 0;
}