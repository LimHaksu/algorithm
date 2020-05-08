#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    int* arr = new int[n];
    for(int i = 0; i < n; ++i){
        cin >> arr[i];
    }
    sort(arr,arr+n);
    int sum, max = 0;
    do{
        sum = 0;
        for(int i = 0;i < n-1; ++i){
            if(arr[i]-arr[i+1]>0)
                sum += arr[i]-arr[i+1];
            else
                sum += arr[i+1]-arr[i];            
        }
        if(sum > max)
            max = sum;
    }while(next_permutation(arr,arr+n));
    cout << max;
    delete[] arr;
    return 0;
}