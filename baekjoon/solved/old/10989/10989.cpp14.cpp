#include <iostream>
#include <vector>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    int n;
    cin >> n;
    vector<int> arr(10001,0);
    int num;
    for(int i = 0; i < n; i++){
        cin >> num;
        arr[num]++; 
    }
    for(int i = 0; i < arr.size(); i++){
        while(arr[i]-- > 0){
            cout << i << "\n";
        }
    }
    return 0;
}