#include <iostream>
#include <string>
using namespace std;

void add_set(int* arr){
    for(int i = 0; i < 10; i++){
        arr[i]++;
    }
}

int main(void){
    int arr[10] = {0,};
    string room_num;
    cin >> room_num;
    int count = 0;
    int length = room_num.length();
    for(int i = 0; i < length ; i++){
        if(arr[(int)(room_num[i]-'0')]<1){
            if((int)(room_num[i]-'0') == 6 && arr[9] > 0){
                arr[9]--;
            }else if((int)(room_num[i]-'0') == 9 && arr[6] > 0){
                arr[6]--;
            }else{
                add_set(arr);
                count++;
                arr[(int)(room_num[i]-'0')]--;
            }
        }else{
            arr[(int)(room_num[i]-'0')]--;
        }
    }
    cout << count;
    return 0;
}