#include <stdio.h>

int main(void)
{
    char cha;
    while((cha=getchar())!=EOF)
    {
        printf("%c", cha);
    }
     return 0;    
}