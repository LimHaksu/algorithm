#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(){
    int n, l;
    cin >> n >> l;
    vector<int> hole(n);
    for(int i = 0; i < n; i++){
        cin >> hole[i];
    }
    sort(hole.begin(), hole.end());
    double min = 0, max = 0;
    int count = 0;
    for(int i = 0; i < n; i++){
        if(hole[i] > max){
            min = hole[i] - 0.5;
            max = min + l;
            count++;
        }        
    }
    cout << count;
    return 0;
}