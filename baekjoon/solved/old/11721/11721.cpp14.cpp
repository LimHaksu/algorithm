#include <iostream>
using namespace std;
int main(){
    char str[101];
    cin >> str;
    int i = 0;
    while(str[i] != NULL){
        cout << str[i];
        if(++i%10 == 0)
            cout << endl;
    }
    return 0;
}