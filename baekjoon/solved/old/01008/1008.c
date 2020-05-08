#include <stdio.h>

int main(void)
{
    double a, b, c;
    scanf("%lf %lf", &a, &b);
    c = a/b;
    printf("%0.10f", c);
    return 0;
}