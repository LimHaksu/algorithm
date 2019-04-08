#include<iostream>
using namespace std;
int main(void){
    int a,b,c;
    int result;
    int arr[10]={0,};
    int parsing;
    cin>>a>>b>>c;
    result = a*b*c;
    while(result!=0){
        parsing = result % 10;
        arr[parsing]++;
        result /= 10;
    }
    for(int i = 0; i< 10; i++){
        cout<<arr[i]<<endl;
    }
    return 0;
}