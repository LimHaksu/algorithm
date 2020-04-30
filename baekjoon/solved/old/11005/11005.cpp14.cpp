#include <iostream>
#include <stack>
using namespace std;
int main(){
    int n, b;
    stack<int> s;
    cin >> n >> b;
    while(n > 0){
        s.push(n%b);
        n /= b;
    }
    int temp;
    while(!s.empty()){
        temp = s.top();
        s.pop();
        if(temp >= 10){
            cout << (char)(temp-10+'A');
        }else{
            cout << temp;
        }
    }
    return 0;    
}