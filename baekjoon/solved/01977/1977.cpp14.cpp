#include <iostream>
using namespace std;
int main(){
    int m, n;
    cin >> m >> n;
    int sum = 0;
    int min = 100000000;
    for(int i = m; i <= n; i++){
        for(int j = 1; j*j <= i; j++){
            if(j*j == i){
                if(i < min)
                    min = i;
                sum += i;
            }
        }
    }
    if(sum != 0){
        cout << sum << "\n" << min;
    }else{
        cout << -1;
    }return 0;
}