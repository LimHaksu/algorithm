#include <stdio.h>

int main(void){
    int n, i=0;
    scanf("%d",&n);
    for(; i<n; i++){
        printf("%d\n",n-i);
    }
    return 0;
}