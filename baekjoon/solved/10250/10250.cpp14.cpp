#include <iostream>
using namespace std;

int main(){
    int testcases;
    cin >> testcases;
    for(int i = 0 ; i < testcases ; i++){
        int h, w, n;
        cin >> h >> w >> n;
        int floor, room;
        floor = n % h;
        if(n%h == 0){
        	floor = h;
        	room = n / h;
        }else{
        	floor = n % h;
        	room  = n / h + 1;
        }
        printf("%d%02d\n", floor, room);
    }
    return 0;
}