#include <iostream>
#include <stack>
using namespace std;
int main(){
    int a, b;
    cin >> a >> b;
    int n , temp;
    cin >> n;
    int sum = 0;
    for(int i = 0; i <n ; i++){
        cin >> temp;
        sum = sum*a + temp;
    }
    stack<int> arr;
    while(sum>0){
        arr.push(sum%b);
        sum /= b;
    }
    while(!arr.empty()){
        cout << arr.top() << " ";
        arr.pop();
    }
    return 0;
}