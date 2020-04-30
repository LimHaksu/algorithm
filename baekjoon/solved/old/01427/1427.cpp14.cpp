#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
int main(){
    string str;
    cin >> str;
    sort(&str[0], &str[0] + str.length());
    for(int i = 1 ; i <= str.length() ; i++){
        cout << str[str.length()-i];
    }
    return 0;
}