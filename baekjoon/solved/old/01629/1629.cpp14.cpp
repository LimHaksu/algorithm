#include <iostream>
using namespace std;
int main(){
    int a,b,c;
    long answer = 1;
    cin >> a >> b >> c;
    long multiply = a%c;
    while(b>0){
		if(b%2==1){
			answer *= multiply;
			answer%=c;
		}
		multiply = ((multiply%c)*(multiply%c))%c;
		b/=2;
	}
    cout << answer;
    return 0;
}