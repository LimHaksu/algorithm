#include <iostream>
using namespace std;
long long min(long long a, long long b){
    return a < b ? a : b;
}
long long max(long long a, long long b){
    return a > b ? a : b;
}
long long gcd(long long a, long long b){
    long long min_n = min(a,b);
    long long max_n = max(a,b);
    long long r = 1;
    while(r != 0){
        r = max_n % min_n;
        max_n = min_n;
        min_n = r;
    }
    return max_n;
}
int main(){
    long long a, b;
    cin >> a >> b;
    int g = gcd(a,b);
    while(g--){
        cout << 1;
    }
    return 0;
}