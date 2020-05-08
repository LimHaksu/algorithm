#include <iostream>
#include <string.h>
using namespace std;
int main(void){
    string str;
    cin >> str;
    int max = 0;
    char char_max;
    int count[26]={0,};
    int count_max = 0;
    for(int i = 0; i< str.length(); i++){
        if(str[i] >= 'a' && str[i] <= 'z'){
            count[(int)(str[i]-'a')]++;
        }else{
            count[(int)(str[i]-'A')]++;
        }
    }
    for(int i = 0 ; i < 26; i++){
        if(count[i] > max){
            max = count[i];
            char_max = (char)(i+'A');
        }
    }
    for(int i = 0 ; i < 26; i++){
        if(count[i] == max){
            count_max++;
        }
    }
    if(count_max > 1){
        cout << "?";
    }else{
        cout << char_max;
    }
    return 0;
}