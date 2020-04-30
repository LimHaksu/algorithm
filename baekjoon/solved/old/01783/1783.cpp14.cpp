#include <iostream>
using namespace std;
int main(){
    int n, m;
    cin >> n >> m;
    int answer = 0;
    if(n >= 3){
        if(m > 6){
            answer = 5 + m - 7; 
        }else{
            answer = m;
            if(m>4)
                answer = 4;
        }
    }else if(n == 2){
        if(m < 8){
            answer = (m+1)/2;
        }else{
            answer = 4;
        }
    }else{
        answer = 1;
    }
    cout << answer;
    return 0;
}