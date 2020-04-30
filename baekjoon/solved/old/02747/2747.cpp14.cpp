#include <iostream>
using namespace std;
int fib(int n, int arr[]){
    if(n==1 || n==2){
        arr[n] = 1;
        return arr[n];
    }
    if(arr[n-1] == 0)
        arr[n-1] = fib(n-1, arr);
    if(arr[n-2] == 0)
        arr[n-2] = fib(n-2, arr);
    return arr[n-1] + arr[n-2];
}
int main(void){
    int n;
    int arr[46]={0,};
    cin >> n;
    cout<< fib(n, arr);
    return 0;
}