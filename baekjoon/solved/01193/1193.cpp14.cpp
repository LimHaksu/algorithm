#include <iostream>
#include <math.h>
using namespace std;

int main(){
    enum STATE {decrease, increase}; // d ↙, i ↗
    int x;
    cin >> x;
    int numerator=1, denominator=1; // n 분자, d 분모
    int i = 1;
    STATE state = decrease;
    if(x>1){
        i++;
        denominator++;
    }
    for(; i < x; i++){
        if(state == decrease){
            if(denominator == 1){
                numerator++;
                state = increase;
                continue;
            }
            numerator++;
            denominator--;
        }else if(state == increase){
            if(numerator == 1){
                denominator++;
                state = decrease;
                continue;
            }
            numerator--;
            denominator++;
        }
    }
    cout << numerator << "/" << denominator;
    return 0;    
}