#include <iostream>
#include <cstdio>
using namespace std;

void hanoi(int current, int des, int empty, int number){
    int temp;
    if(number == 1){
        cout << current << " " << des << '\n';
        return;
    }
    hanoi(current, empty, des, number-1);
    cout << current << " " << des << '\n';
    hanoi(empty, des, current, number-1);
}
int hanoi_cal(int n){
    if(n == 1)
        return 1;
    return 2* hanoi_cal(n-1) + 1;
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    cout << hanoi_cal(n) << endl;
    hanoi(1,3,2,n);
    return 0;
}