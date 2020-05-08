#include <iostream>
using namespace std;

int main(void){
    ios_base::sync_with_stdio(false);
    int m, n;
    cin >> m >> n;
    int arr[n+1]={0,};
    for(int i = 2; i < n+1 ; i++){
        if(arr[i] == 0){
            if(i >= m){
                cout << i << "\n";
            }
            int k = i;
            for(int j = 1; (k=i*j) < n+1 ; j++ ){
                arr[k] = 1;
            }
        }
    }
    return 0;
}