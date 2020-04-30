#include<iostream>
using namespace std;
int main(void){
    int start;
    int previous;
    int current;
    cin>>start;
    previous = start;
    int i = 0;
    switch(start){
        case 1:
            for(; i< 7; i++){
                cin>>current;
                if(current<previous){
                    break;
                }else{
                    previous = current;
                }
            }
            if(i==7){
                cout<<"ascending";
            }else{
                cout<<"mixed";
            }
            break;
        case 8:
            for(; i< 7; i++){
                cin>>current;
                if(current>previous){
                    break;
                }else{
                    previous = current;
                }
            }
            if(i==7){
                cout<<"descending";
            }else{
                cout<<"mixed";
            }
            break;            
        default:
            cout<<"mixed";
    }
    return 0;
}