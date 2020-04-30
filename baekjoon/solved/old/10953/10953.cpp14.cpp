#include <stdio.h>
int main(){
    int t,a,b;
    scanf("%d\n",&t);
    for(int i = 0; i < t; i++){
        scanf("%d,%d\n",&a,&b);
        printf("%d\n",a+b);
    }
    return 0;
}