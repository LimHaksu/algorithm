#include <iostream>
using namespace std;
int count_two(int n){
    int count = 0;
    while(n % 2 == 0){
        count++;
        n /= 2;
    }
    return count;
}
int count_five(int n){
    int count = 0;
    while(n % 5 == 0){
        count++;
        n /= 5;
    }
    return count;
}
int main(){
    int n;
    cin >> n;
    int num_of_two = 0, num_of_five = 0;
    while(n){
        num_of_two += count_two(n);
        num_of_five += count_five(n);
        n--;
    }
    int min = num_of_two < num_of_five ? num_of_two : num_of_five;
    cout << min;
    return 0;
}