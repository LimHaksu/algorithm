#include <iostream>
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
    int max = 0;
    for(int i = 1; i < n-2; ++i){
        for(int j = i+1; j < n-1; ++j){
            for(int k = j+1; k < n; ++k){
                int sum = 0, sum1 = 1, sum2 = 1, sum3 = 1, sum4 = 1;
                for(int first = 0; first < i; ++first){
                    sum1 *= arr[first];
                }
                for(int second = i; second < j; ++second){
                    sum2 *= arr[second];
                }
                for(int third = j; third < k; ++third){
                    sum3 *= arr[third];
                }
                for(int fourth = k; fourth < n; ++fourth){
                    sum4 *= arr[fourth];
                }
                sum = sum1+sum2+sum3+sum4;
                if(sum>max){
                    max = sum;
                }
            }
        }
    }
    cout << max;
    delete[] arr;
    return 0;
}