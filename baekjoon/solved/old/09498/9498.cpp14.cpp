#include<iostream>
using namespace std;
int main(){
    int points;
    cin>>points;
    if(points>=90){
        cout<<"A";
    }else if(points>=80){
        cout<<"B";
    }else if(points>=70){
        cout<<"C";
    }else if(points>=60){
        cout<<"D";
    }else{
        cout<<"F";
    }
    return 0;
}