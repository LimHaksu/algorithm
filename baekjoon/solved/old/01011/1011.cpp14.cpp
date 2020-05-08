#include <iostream>
#include <math.h>
using namespace std;

int main(void){
    int testcases;
    cin >> testcases;
    unsigned int x, y, d;
    unsigned int max_dis = pow(2,31);
    for(int i=0; i<testcases; i++){
        cin >> x >> y;
        d = y-x;
        for(unsigned int j = 1; j < max_dis; j++){
            if(d==j*j){
                cout << j*2-1 << endl;
                break;
            }else if(j*j < d && d <= (j*j+(j+1)*(j+1))/2){
                cout <<j*2 << endl;
                break;
            }else if((j*j+(j+1)*(j+1))/2 < d && d <= (j+1)*(j+1)){
                cout << (j+1)*2 - 1 << endl;
                break;
            }
        }         
    }
    return 0;
}