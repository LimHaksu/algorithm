#include <iostream>
#include <string.h>
using namespace std;
int main(void){
    int n;
    cin >> n;
    string str;
    int count = 0;
    for(int i = 0; i < n; i++){
	    int alphabet[26]={0,};
        cin >> str;
        int j = 0;
        for(; j < str.length(); j++){
            if(j == 0 || str[j]==str[j-1] || alphabet[(int)(str[j]-'a')] == 0){
                alphabet[(int)(str[j]-'a')]++;
            }else{
                break;
            }
        }
        if(j == str.length()){
            count++;
        }
    }
    cout<<count;
    return 0;
}