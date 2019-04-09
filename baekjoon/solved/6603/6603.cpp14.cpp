#include <iostream>
#include <string>
#include <vector>
#include <cstdio>
using namespace std;
void dfs(int current_index, vector<int>& arr, string s, int k, int count){
    if(count == 6){
        cout << s << '\n';
        return;
    }
    for(int i = current_index + 1; i < k; ++i){
        dfs(i,arr,s+to_string(arr[i])+" ",k,count+1);
    }
}
int main(){
    freopen("input.txt","r",stdin);
    while(true){
        int k;
        cin >> k;
        if(k == 0)
            break;
        vector<int> arr(k);
        for(int i = 0; i < k; ++i){
            cin >> arr[i];
        }
        string s = "";
        int count = 0;
        for(int i = 0; i <= k-6; ++i){
            dfs(i,arr,s+to_string(arr[i])+" ",k,1);
        }
        cout << '\n';
    }
    return 0;
}