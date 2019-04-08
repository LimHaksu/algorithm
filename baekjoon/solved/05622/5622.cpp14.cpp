#include<iostream>
#include <string>
using namespace std;
int main(void){
    int dial[26]={
        3,3,3,
        4,4,4,
        5,5,5,
        6,6,6,
        7,7,7,
        8,8,8,8,
        9,9,9,
        10,10,10,10
    };
    int total = 0;
    string str;
    cin >> str;
    for (int i = 0 ; i < str.length(); i++){
        total += dial[(int)(str[i]-'A')];
    }
    cout << total;
    return 0;
}