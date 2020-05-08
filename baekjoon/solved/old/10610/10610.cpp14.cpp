#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int main(){
    string number;
    cin >> number;
    sort(number.begin(), number.end(), greater<char>());
    int sum = 0;
    for(int i = 0; i < number.size(); i++){
        sum += number[i] - '0';
    }
    if(sum % 3 == 0 && number[number.size()-1] == '0')
        cout << number;
    else
        cout << -1;
    return 0;
}