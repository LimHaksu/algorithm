#include <iostream>
using namespace std;

int main(void){
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
    int testcases;
    cin >> testcases;
    int a, b;
    for(int i = 0; i < testcases; i++){
        cin >> a >> b;
        cout << a+b << "\n";
    }
    return 0;
}