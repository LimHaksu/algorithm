#include <stdio.h>
using namespace std;
int main(){
    int n;
    scanf("%d",&n);
    int* arr = new int[n];
    for(int i = 0; i < n; i++){
         scanf("%d",arr+i);
    }
    int min = 1000000;
    int max = -1000000;
    for(int i = 0; i < n; i++){
        if(min > arr[i])
            min = arr[i];
        if(max < arr[i])
            max = arr[i];
    }
    printf("%d %d", min, max);
    delete arr;
    return 0;
}