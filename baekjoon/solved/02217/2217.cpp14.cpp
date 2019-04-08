#include <iostream>
#include <vector>
#include <map>
#include <utility>
#include <algorithm>
using namespace std;
bool compare(pair<int,int>&a, pair<int,int>&b){
    return a.first > b.first;
}
int main(){
    int n;
    cin >> n;
    map<int,int> num_of_rope; // weight, the number
    vector<pair<int,int>> num_of_rope_list; // weight, the number
    int temp;
    for(int i = 0 ; i < n ;i++){
        cin >> temp;
        if(num_of_rope.find(temp) == num_of_rope.end()){
            num_of_rope[temp] = 1;
        }else{
            num_of_rope[temp]++;
        }
    }
    for(map<int,int>::iterator it = num_of_rope.begin(); it != num_of_rope.end() ; it++){
        num_of_rope_list.push_back(pair<int,int>(it->first, it->second));    
    }
    sort(num_of_rope_list.begin(), num_of_rope_list.end(), compare);
    int max = num_of_rope_list[0].first * num_of_rope_list[0].second;
    int count = num_of_rope_list[0].second;
    for(int i = 1; i < num_of_rope_list.size(); i++){
        count += num_of_rope_list[i].second;
        max = max > num_of_rope_list[i].first * count ? max : num_of_rope_list[i].first * count;        
    }
    cout << max;
    return 0;
}