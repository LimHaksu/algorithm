#include <iostream>
using namespace std;
int main(){
    int n, m, k;
    cin >> n >> m >> k;
    int answer = 0;
    for(int i = 1; i <= m; i++){
        if(2*i <= n){
            if(3*i <= n+m-k){
                answer = i;
            }
        }
    }
    cout << answer;
    return 0;
}