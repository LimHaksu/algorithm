#include <iostream>
#include <vector>
using namespace std;
bool check(vector<bool>& avail, int n){
    if(n == 0 && avail[n] == false)
    	return false;
    while(n){
        if(avail[n%10] == false)
            return false;
        n /= 10;
    }
    return true;    
}
int distance(int a, int b){
    return a > b ? a-b : b-a;
}
int length(int a){
    int len = 0;
    do{
        len++;
        a /= 10;
    }while(a);
    return len;
}
int main(){
    int n;
    cin >> n;
    int m;
    cin >> m;
    vector<bool> avail(10,true);
    int temp;
    for(int i = 0; i < m; i++){
        cin >> temp;
        avail[temp] = false;
    }
    int min = distance(n,100);
    for(int i = 0; i < 1000000; i++){
        if(check(avail,i)){
            temp = distance(n,i) + length(i);
            min = min < temp ? min : temp;
        }     
    }
    cout << min;
    return 0;
}