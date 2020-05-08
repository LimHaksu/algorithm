#include <iostream>
#include <string>
using namespace std;
int main(){
    int a,b,c,d;
    string first, second;
    cin >> a >> b >> c >> d;
    first = to_string(a) + to_string(b);
    second = to_string(c) + to_string(d);
    cout << stoll(first)+stoll(second);
    return 0;
}