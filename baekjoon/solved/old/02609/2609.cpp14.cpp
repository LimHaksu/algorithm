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
int lcm(int a, int b, int gcd){
    return a/gcd*b;
}
int main(){
    int a,b, g;
    cin >> a >> b;
    g = gcd(a,b);
    cout << g << "\n" << lcm(a,b,g);
    return 0;    
}