#include<iostream>
using namespace std;
int main(void){
    int num[10001]={0};
    for(int i = 1 ; i<= 10000; i++){
        if(i<10){
            num[i*2]=1;//1:chek
        }else if(i<100){
            num[i+i/10+i%10]=1;
        }else if(i<1000){
            num[i+i/100+(i/10)%10+i%10]=1;
        }else{
        	int temp = i+i/1000+(i/100)%10+(i/10)%10+i%10;
        	if(temp<=10000)
                num[temp]=1;
        }
    }
    for(int i=1; i<=10000;i++){
        if(num[i]==0){
            cout<<i<<endl;
        }
    }
}