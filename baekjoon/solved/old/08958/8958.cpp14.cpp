#include<iostream>
#include<string.h>
using namespace std;
int main(void){
    int testcases;
    cin>> testcases;
    for(int i = 0; i < testcases; i++){
        string str;
        cin >> str;
        int pts[str.length()]={0,};
        int total= 0;
        for(int j = 0; j< str.length(); j++){
            if(j==0){
                if(str[j]=='O'){
                    pts[j] = 1;
                }
            }else{
                if(str[j]=='O'){
                    pts[j] += (pts[j-1]+1);
                }
            }
            total += pts[j];
        }
        cout<<total<<endl;
    }
    return 0;
}