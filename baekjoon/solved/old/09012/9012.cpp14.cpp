#include <iostream>
#include <vector>

using namespace std;
int main(){
    vector<bool> s;
    int n;
    cin >> n;
    string str;
    for(int i = 0; i < n; i++){
        cin >> str;
        bool vps = false;
        for(int j = 0 ; j < str.length(); j++){
            if(str[j] == '('){
                s.push_back(true);
                vps = false;
            }else{
                if(s.size() > 0){
                    s.pop_back();
                    vps = true;
                }else{
                    vps = false;
                    break;
                }
            }
        }
        if(s.size() == 0 && vps == true)
            cout << "YES\n";
        else
            cout << "NO\n";
        s.clear();
    }
    return 0;
}