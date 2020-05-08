#include <iostream>
#include <string>
using namespace std;
int main(){
    int b;
    string n;
    cin >> n >> b;
    int sum = 0;
    int temp;
    for(int i = 0; i < n.size() ; i++){
        if(n[i] >= 'A' && n[i] <= 'Z')
            temp = (int)(n[i] - 'A' + 10);
        else
            temp = (int)(n[i] - '0');
        sum = sum*b + temp;
    }
    cout << sum;
    return 0;
}