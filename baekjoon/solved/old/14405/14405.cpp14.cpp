#include <iostream>
#include <string>
using namespace std;
int main(){
    string pikachu;
    cin >> pikachu;
    for(int i = 0; i < pikachu.size(); i++){
        if(pikachu[i] == 'p' && i+1 < pikachu.size() && pikachu[i+1] == 'i'){
            i++;
        }else if(pikachu[i] == 'k' && i+1 < pikachu.size() && pikachu[i+1] == 'a'){
            i++;
        }else if(pikachu[i] == 'c' && i+1 < pikachu.size() && pikachu[i+1] == 'h' 
                 && i+2 < pikachu.size() && pikachu[i+2] == 'u'){
            i+=2;
        }else{
            cout << "NO";
            return 0;
        }
    }
    cout << "YES";
    return 0;
}