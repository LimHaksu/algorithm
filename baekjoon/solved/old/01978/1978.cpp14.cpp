#include <iostream>
using namespace std;

int main(void){
    int num_of_num;
    cin >> num_of_num;
    int arr[1001] = {1,1,0,};
    for(int i = 2; i < 1001 ; i++){
        if(arr[i] == 0){
            int k;
            for(int j = 2; (k=i*j) < 1001; j++){
                arr[k] = 1;
            }
        }
    }
    int num, count = 0;
    for(int i = 0; i < num_of_num; i++){
        cin >> num;
        if(arr[num] == 0){
            count++;
        }
    }
    cout << count;
    return 0;
}
