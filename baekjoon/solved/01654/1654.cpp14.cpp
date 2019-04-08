#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    int k, n;
    cin >> k >> n;
    vector<int> lans(k);
    for(int i = 0; i < k ; i++){
        cin >> lans[i];
    }
    long long max = 0x7FFFFFFF;
    long long min = 1;
    long long answer = 0;
    long long sum, mid;
    while(min <= max){
        sum = 0;
        mid = (max + min) / 2;
        for(int i = 0; i < k; i++){
            sum += (lans[i]/mid);
        }
        if(sum >= n){
            min = mid + 1;
            if(mid > answer)
                answer = mid;
        }else{ // sum < n
            max = mid - 1;
        }
    }
    cout << answer;
    return 0;
}