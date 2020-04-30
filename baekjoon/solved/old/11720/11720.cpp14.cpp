#include <iostream>
#include <string>
using namespace std;
int main(){
    int t, sum = 0;
    string number;
    cin >> t >> number;
    for(int i = 0; i < t; i++){
        sum += (int)(number[i]-'0');
    }
    cout << sum;
    return 0;
}