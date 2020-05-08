#include <iostream>

using namespace std;

typedef long long ll;

int main() {
    int t;
    cin >> t;
    while(t--) {
        ll x1, y1, r1, x2, y2, r2;
        cin >> x1 >> y1 >> r1 >>x2 >>y2 >> r2;
        ll dx = x1-x2;
        ll dy = y1-y2;

        if (r1 > r2) swap(r1, r2);
        ll add = r1 + r2;
        add = add * add;
        ll sub = r2 - r1;
        sub = sub * sub;
        ll d = dx*dx + dy*dy;
        
        if (d < add && d > sub) {
            cout << 2;
        } else if (d == add || (d == sub && d != 0) ) {
            cout << 1;
        } else if (d < sub || d > add) {
            cout << 0;
        } else if (d ==0) {
            if (r1 == r2)
                cout << -1;
            else
                cout << 0;
        }
        cout << '\n';
    }
    return 0;
    
}