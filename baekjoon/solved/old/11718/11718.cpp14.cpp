#include <stdio.h>
int main(){
    char one;
    while((one = getchar()) != EOF){
        printf("%c",one);
    }
    return 0;
}