#include <iostream>
using namespace std;

int main(void){
    int n;
    while(1){
        cin >> n;
        if(n==0){
            break;
        }
        int arr[2*n+1]={1,1,0,};
        for(int i = 2; i < 2*n+1; i++ ){
            if(arr[i] == 0){
                int k;
                for(int j = 2; (k = i*j) < 2*n+1; j++){
                    arr[k] = 1;
                }
            }
        }
        int count = 0;
        for(int i = n+1; i < 2*n+1; i++){
            if(arr[i] == 0){
                count++;
            }
        }
        cout << count << endl;
    }
    return 0;
}