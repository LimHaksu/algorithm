#include <iostream>
using namespace std;
int my_min(int n1, int n2, int n3){
    int min1;
    if(n1 > n2)
        min1 = n2;
    else
        min1 = n1;
    if(min1 > n3)
        min1 = n3;
    return min1;
}
int main(){
    int n;
    cin >> n;
    int *arr = new int[n+1];
    arr[1] = 0;
    arr[2] = 1;
    arr[3] = 1;
    int temp1, temp2;
    for(int i = 4; i <= n ; i++){
        if(i%2 == 0)
            temp1 = arr[i/2]+1;
        else
            temp1 = 987654321;
        if(i%3 == 0)
            temp2 = arr[i/3]+1;
        else
            temp2 = 987654321;
        arr[i] = my_min(temp1, temp2, arr[i-1]+1);
    }
    cout << arr[n];
    return 0;
}