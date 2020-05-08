#include<iostream>
#include<string>
using namespace std;
int main(void){
    string str;
    cin >> str;
    int count = 0;
    for(int i = 0 ; i < str.length(); i++){
        switch(str[i]){
            case 'd':
                if(str[i+1]=='z' && str[i+2]=='='){
                    count++;
                    i+=2;
                    break;
                }else if(str[i+1]=='-'){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                }
            case 'c':
                if(str[i+1]=='=' || str[i+1]=='-'){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                }                
            case 'l':
                if(str[i+1]=='j'){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                } 
            case 'n':
                if(str[i+1]=='j'){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                }
            case 's':
                if(str[i+1]=='='){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                }
            case 'z':
                if(str[i+1]=='='){
                    count++;
                    i++;
                    break;
                }else{
                    count++;
                    break;
                }                
            default:
                count++;
        }
    }
    cout << count;
    return 0;
}