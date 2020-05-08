#include<iostream>
using namespace std;
int main(void){
    int n;
    cin >> n;
    int sum=1, i;
    for(i = 1; n > sum; i++){
        sum += 6*i;  
    }
    cout << i;
    return 0;
}