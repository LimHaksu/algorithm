#include <iostream>
#include <string.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    string *strings = new string[n];
    for(int i = 0; i < n; i++){
        cin >> strings[i];
    }
    string result = "";
    for(int j = 0; j < strings[0].length(); j++){
        int i = 0;
        for(; i < n-1; i++){
            if(strings[i][j] != strings[i+1][j])
                break;
        }
        if(i == n-1)
            result += strings[i][j];
        else
            result += "?";
    }
    cout << result;
    delete[] strings;
    return 0;
}