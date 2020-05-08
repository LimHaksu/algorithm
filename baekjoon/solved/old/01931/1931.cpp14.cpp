#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;
bool compare(pair<int,int>& a, pair<int,int>& b){
    if(a.second == b.second){
        return a.first < b.first;
    }
    return a.second < b.second;
}
int main(){
    int n;
    cin >> n;
    vector<pair<int,int>> meetings(n);
    for(int i = 0; i < n; i++){
        cin >> meetings[i].first >> meetings[i].second;
    }
    sort(meetings.begin(), meetings.end(), compare);
    int end = 0;
    int count = 0;
    for(int i = 0; i < n; i++){
        if(meetings[i].first >= end){
            end = meetings[i].second;
            count++;
        }
    }
    cout << count;
    return 0;
}