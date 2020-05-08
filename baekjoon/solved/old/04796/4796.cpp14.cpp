#include <iostream>
using namespace std;
int min(int a, int b){
    return a < b ? a : b;
}
int main(){
    int l, p, v;
    for(int i = 1; ; i++){
        cin >> l >> p >> v;
        if(l == 0 && p == 0 && v == 0)
            break;
        cout << "Case " << i << ": " << (v/p)*l + min(v%p , l) << "\n";
    }
    return 0;
}