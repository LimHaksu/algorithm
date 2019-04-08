#include <iostream>
#include <tuple>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;
int main(){
    int n;
    cin >> n;
    vector<tuple<int,int,string>> table(n);
    int age;
    string name;
    for(int i = 0; i < n; i++){
        cin >> age >> name;
        table[i] = make_tuple(age,i,name);
    }
    sort(table.begin(), table.end());
    for(int i = 0; i < n; i++){
        cout << get<0>(table[i]) << " " << get<2>(table[i]) << "\n";
    }
    return 0;
}