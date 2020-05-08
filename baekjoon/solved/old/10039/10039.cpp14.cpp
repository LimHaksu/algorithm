#include<iostream>
using namespace std;
int main(void){
    int arr[5];
    for(int i = 0 ; i < 5; i++){
        cin >> arr[i];
    }
    for(int i = 0 ; i < 5; i++){
        if(arr[i]<40){
            arr[i] = 40;
        }
    }
    int total = 0;
    for(int i = 0 ; i < 5; i++){
        total += arr[i];
    }
    cout<<total/5;
    return 0;
}