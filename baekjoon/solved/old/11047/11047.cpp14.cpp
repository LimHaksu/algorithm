#include <iostream>
#include <vector>
using namespace std;
int main(){
    int n, total;
    cin >> n >> total;
    vector<int> coin(n);
    for(int i = 0; i < n; i++){
        cin >> coin[i];
    }
    int count = 0;
    for(int i = n-1; i >= 0; i--){
        if(coin[i]<=total){
            total -= coin[i];
            i++;
            count++;
        }
    }
    cout << count;
    return 0;
}