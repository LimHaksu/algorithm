#include <stdio.h>
int main(){
    int testcases;
    int case_number = 0;
    int a, b;
    scanf("%d", &testcases);
    while(testcases--){
        scanf("%d %d", &a, &b);
        printf("Case #%d: %d + %d = %d\n", ++case_number, a, b, a+b);
    }
    return 0;
}