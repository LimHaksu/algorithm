#include <iostream>
using namespace std;
int min(int a, int b){
    return a < b ? a : b;
}
int gcd(int a, int b){
    int m = min(a,b);
    int max = (m==a)? b : a;
    int remain = 1;
    while(remain != 0){
        remain = max % m;
        max = m;
        m = remain;
    }
    return max;
}
int lcm(int a, int b, int g){
    return a/g*b;
}
int main(){
    int T;
    int a, b;
    cin >> T;
    while(T--){
        cin >> a >> b;
        cout << lcm(a,b,gcd(a,b)) << "\n";
    }
    return 0;
}