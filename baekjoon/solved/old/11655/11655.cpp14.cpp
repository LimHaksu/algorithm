#include <iostream>
#include <string>
using namespace std;
int main(){
    string s;
    getline(cin,s);
    for(int i = 0; i < s.length(); i++){
        if((s[i] >= 'a' && s[i] <= 'z')){
            cout << (char)((s[i]-'a'+13)%26+'a');
        }else if((s[i] >= 'A' && s[i] <= 'Z')){
            cout << (char)((s[i]-'A'+13)%26+'A');
        }else
            cout << (char)s[i];
    }
    return 0;
}