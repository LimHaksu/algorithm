#include <iostream>
using namespace std;
void fibonacci(int n, int arr[][41]) {
    for(int i = 2; i<n+1; i++){
        for(int j = 0; j < 2 ; j++)
            arr[j][i] = arr[j][i-1]+arr[j][i-2];
    }
}

int main(){
    int testcases;
    scanf("%d",&testcases);
    for(int i = 0; i < testcases; i++){
        int n;
        scanf("%d",&n);
        int arr[2][41]={{1,0,},{0,1,0,}};
        fibonacci(n, arr);
        printf("%d %d\n",arr[0][n],arr[1][n]);
    }
    return 0;
}