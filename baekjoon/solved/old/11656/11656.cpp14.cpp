#include <iostream>
#include <string>
#include <queue>
using namespace std;
int main(){
    priority_queue<string,vector<string>,greater<string>> pq;
    string s;
    cin >> s;
    int length = s.length();
    for(int i = 0; i < length; i++){
        pq.push(s);
        s.erase(s.begin());
    }
    for(int i = 0; i < length; i++){
        cout << pq.top() << "\n";
        pq.pop();
    }
    return 0;
}