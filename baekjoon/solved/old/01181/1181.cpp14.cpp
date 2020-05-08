#include <iostream>
#include <vector>
#include <set>
#include <string>
#include <algorithm>
using namespace std;
bool compare(string&a, string&b){
    if(a.length() == b.length()){
        return a < b? true : false;
    }
    return a.length() < b.length() ? true : false;
}
int main(){
    int n;
    cin >> n;
    set<string> words;
    string temp;
    for(int i = 0; i < n; i++){
        cin >> temp;
        words.insert(temp);
    }
    vector<string> list;
    for(set<string>::iterator it = words.begin(); it != words.end(); it++){
        list.push_back(*it);
    }
    sort(list.begin(), list.end(), compare);
    for(int i = 0; i < list.size(); i++){
        cout << list[i] << "\n";
    }
    return 0;
}