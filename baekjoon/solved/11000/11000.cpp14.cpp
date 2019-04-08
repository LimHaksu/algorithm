#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>
using namespace std;
typedef pair<int,int> iipair;
int main(){
    int n;
    cin >> n;
    vector<iipair> classes(n);
    for(int i = 0; i < n; i++){
        cin >> classes[i].first >> classes[i].second;
    }
    sort(classes.begin(), classes.end());
    priority_queue<int,vector<int>,greater<int>> checked_class;
    checked_class.push(classes[0].second);
    int count = 1;
    for(int i = 1; i < n; i++){
        if(classes[i].first >= checked_class.top()){
            checked_class.pop();
            checked_class.push(classes[i].second);
        }else{
            count++;
            checked_class.push(classes[i].second);
        }
    }
    cout << count;
    return 0;
}