#include <iostream>
using namespace std;

int main(){
    int m,n,x,y;
    int testcases;
    cin >> testcases;
    for(int i = 0; i < testcases ; i++){
        cin >> m >> n >> x >> y;
        if(n>m){
            int j = 1;
            for(;j < n; j++){
                if(j%n==y){
                    break;
                }else if(j%n==0 && y==n){
                    break;
                }
            }
            while(j < m*n){
                if(j%m == x || (j%m == 0 && x == m)){
                    cout << j << endl;
                    break;
                }
                j += n;
            }
            if(j >= m*n){
                    cout << -1 << endl;
            }
        }else{
            int j = 1;
            for(;j < m; j++){
                if(j%m==x){
                    break;
                }else if(j%m==0 && x==m){
                    break;
                }
            }
            while(j < m*n){
                if(j%n == y || (j%n == 0 && y == n)){
                    cout << j << endl;
                    break;
                }
                j += m;
            }
            if(j >= m*n){
                cout << -1 << endl;
            }
        }
    }
    return 0;
}