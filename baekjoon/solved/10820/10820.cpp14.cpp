#include <iostream>
#include <string>
using namespace std;
int main(){
    string s;
    int small, big, num, spc;
    while(getline(cin,s)){
        small = big = num = spc = 0;
        for(int i = 0; i < s.length(); i++){
            if(s[i]>= 'a' && s[i] <= 'z'){
                small++;
            }else if(s[i] >= 'A' && s[i] <= 'Z'){
                big++;
            }else if(s[i] == ' '){
                spc++;
            }else if(s[i] >= '0' && s[i] <= '9'){
                num++;
            }
        }
        cout << small << " " << big << " " << num << " " << spc << "\n";
    }
    return 0;
}