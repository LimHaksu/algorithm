#include<iostream>
#include<string.h>
using namespace std;
int main(void){
    int testcases;
    cin >> testcases;
    for(int i = 0 ; i < testcases; i++){
        int n;
        string str;
        cin >> n >> str;
        for(int k = 0; k < str.length() ; k++){
            for(int j = 0; j < n; j++){
                cout<<str[k];   
            }
        }
        cout<<endl;
    }
    return 0;
}