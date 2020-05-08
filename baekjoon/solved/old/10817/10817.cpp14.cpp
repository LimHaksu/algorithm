#include<iostream>
using namespace std;
int main(){
    int a, b, c;
    int second;
    cin>>a>>b>>c;
    if(a>b){
        if(b>c){
            second = b;
        }else if(a>c){
            second = c;
        }else{
            second = a;
        }
    }else{
        if(a>c){
            second = a;
        }else if(b>c){
            second = c;
        }else{
            second = b;
        }
    }
    cout<<second;
    return 0;
}