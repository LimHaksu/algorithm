#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main(){
    string n;
    cin >> n;
    stack<int> s;
    int count = 0;
    int temp = 0; // 0~7;
    int sum = 0;
    for(int i = n.size()-1; i >= 0; i--){
        int temp2 = (n[i]-'0') % 2;
        switch(count){
            case 0:
                temp += temp2;
                break;
            case 1:
                temp += temp2*2;
                break;
            case 2:
                temp += temp2*4;
                break;                
        }
        count++;
        if(count == 3 || i == 0){
            count = 0;
            s.push(temp);
            temp = 0;
        }
    }
    while(!s.empty()){
    	cout << s.top();
    	s.pop();
    }
    return 0;
}