#include<iostream>
using namespace std;
int main(void){
    int num;
    int new_num;
    cin>>num;
    int count=0;
    int sum;
    new_num = num;
    while(1){
        sum = new_num%10 + new_num/10;
        new_num = new_num%10*10 + sum%10;
        count++;
        if(num == new_num){
            break;
        }
    }
    cout<<count;
    return 0;
}