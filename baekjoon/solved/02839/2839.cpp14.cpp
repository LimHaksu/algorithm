#include<iostream>
using namespace std;
int main(){
    int r, count=0;
    cin>>r;
    while(1){
        switch(r){
            case 3:
                count++;
                r -= 3;
                break;
            case 4: count = -1;
                break;
            case 5:
                count++;
                r -= 5;
                break;
            case 6:
                count += 2;
                r -= 6;
                break;
            case 7: count = -1;
                break;
            case 9:
                count +=3;
                r -= 9;
                break;
            case 12:
                count +=4;
                r -= 12;
                break;
            default:
                if(r>5){
                    r -= 5;
                    count++;
                    break;
                }else{
                    count = -1;
                    break;
                }
        }
        if(r == 0 || count == -1){
            break;
        }
    }
    cout << count;
    return 0;
}