#include <iostream>
#include <vector>
#include <string>
using namespace std;
int main(){
    string s;
    cin >> s;
    vector<int> v(26,-1);
    for(int i = 0; i < s.length(); i++){
        if(v[s[i]-'a'] == -1){
            v[s[i]-'a'] = i;
        }
    }
    for(int i = 0; i < 26; i++){
        cout << v[i] << " ";
    }
    return 0;
}