#include <iostream>
#include <stack>
using namespace std;
int main(){
    stack<int> s;
    string op;
    int n, number;
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> op;
        if(op == "push"){
            cin >> number;
            s.push(number);    
        }else if(op == "pop"){
            if(s.size() > 0){
                cout << s.top() << "\n";
                s.pop();
            }else{
                cout << -1 << "\n";
            }
        }else if( op == "size"){
            cout << s.size() << "\n";
        }else if(op == "empty"){
            s.empty() ? cout << 1 <<"\n" : cout <<  0 << "\n";
        }else if(op == "top"){
            if(s.size() > 0){
                cout << s.top() << "\n";
            }else{
                cout << -1 << "\n";
            }
        }        
    }
    return 0;
}