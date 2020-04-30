#include <iostream>
#include <vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);cin.tie(0);
    int arr[1000001] = {1,1,0,};
    for(int i = 2; i < 1000001; i++){
        if(arr[i] == 0){
            for(int j = 2*i; j < 1000001; j+=i){
                arr[j] = 1;
            }
        }
    }arr[2]=1;
    while(true){
        int n;
        cin >> n;
        if(n == 0)
            break;
        bool conjecture = false;
        for(int i = 3 ; i <= n/2; i++){
            if(arr[i] == 0 && arr[n-i] == 0){
                cout << n << " = " << i << " + " << n-i << "\n";
                conjecture = true;
                break;
            }
        }
        if(conjecture == false){
            cout << "Goldbach's conjecture is wrong\n";
        }
    }
    return 0;
}