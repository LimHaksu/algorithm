#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
bool check(vector<int>& houses, int mid, int c){
    int count = 1;
    int current = 0;
    for(int i = 1; i < houses.size(); i++){
        if(houses[i] - houses[current] >= mid){
            count++;
            current = i;
        }
    }
    return count >= c ? true : false;    
}
int main(){
    int n, c;
    cin >> n >> c;
    vector<int> houses(n);
    int min = 1000000000, max = 0;
    for(int i = 0; i < n; i++){
        cin >> houses[i];
        if(min > houses[i])
            min = houses[i];
        if(max < houses[i])
            max = houses[i];
    }
    sort(houses.begin(), houses.end());
    int left = min;
    int right = max;
    int mid, answer = 0;
    while(left <= right){
        mid = (left + right) /2 ;
        if(check(houses,mid,c)){
            left = mid + 1;
            if(mid > answer)
                answer = mid;
        }else{
            right = mid - 1;
        }
    }
    cout << answer;
    return 0;
}