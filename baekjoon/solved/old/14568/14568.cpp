#include <iostream>
using namespace std;
int main(){
    int n;
    cin >> n;
    int count = 0;
    for(int i = 1; i < n; ++i){
        for(int j = 1; j < n; ++j){
            for(int k = 1; k < n; ++k){
                if(i+j+k == n && k >= j+2 && i % 2 == 0){
                    count++;
                }
            }
        }
    }
    cout << count;
    return 0;
}