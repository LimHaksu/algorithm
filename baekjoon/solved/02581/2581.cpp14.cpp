#include <iostream>
using namespace std;
int main(void){
    int m,n;
    cin >> m >> n;
    int arr[n+1]={1,1,0,};
    for(int i = 2; i < n+1; i++){
        if(arr[i]==0){
            int k;
            for(int j = 2; (k=i*j)< n+1; j++){
                arr[k] = 1;
            }
        }
    }
    int sum = 0;
    int min = n;
    for(int i = m; i < n+1; i++){
        if(arr[i] == 0){
            sum += i;
            if(min > i){
                min = i;
            }
        }
    }
    if(sum==0){
        cout << -1;
    }else{
        cout << sum << "\n" << min;
    }
    return 0;
}