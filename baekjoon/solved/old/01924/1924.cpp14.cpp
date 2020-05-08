#include <iostream>
#include <string.h>
using namespace std;
int main(){
    int days_in_month[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    string week[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int total_days = 0;
    int month, day;
    cin >> month >> day;
    for(int i = 1; i < month; i++){
        total_days += days_in_month[i];
    }
    total_days += day;
    cout << week[total_days % 7];    
    return 0;
}