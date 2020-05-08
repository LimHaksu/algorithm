//test set 1 ok, test set 2 WA
//각 단어 뒤에서부터 map에 넣고 1 증가 
// 모두 수행후 map[단어] == 2인것만 카운트 * 2
#include <iostream>
#include <map>
#include <string>
#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
bool compare(string a, string b){
    if(a.size() > b.size()){
        return true;
    }
    return false;
}
int main(){
    freopen("input.txt","r",stdin);
    int t;
    cin >> t;
    for(int test = 0; test < t; ++test){
        int n;
        cin >> n;
        string s;
        map<string,int> dict;
        for(int i = 0; i < n; ++i){
            cin >> s;
            for(int i = 0; i < s.size(); ++i){
                dict[s.substr(i,s.size())]++;
            }
        }
        int count = 0;
        vector<string> dict_vector;
        dict_vector.reserve(dict.size());
        for(map<string,int>::iterator it = dict.begin(); it != dict.end(); ++it){
            dict_vector.push_back(it->first);
        }
        sort(dict_vector.begin(),dict_vector.end(),compare);
        for(int i = 0; i < dict_vector.size(); ++i){
            if(dict[dict_vector[i]] == 2){
                for(int j = 1; j < dict_vector[i].size(); ++j){
                    dict[dict_vector[i].substr(j,dict_vector[i].size())] -= 2;
                }
            }
        }       
        for(map<string,int>::iterator it = dict.begin(); it != dict.end(); ++it){
            if(it->second >= 2){
                count += 2;
            }
        }
        cout << "Case #" << test+1 << ": " << count << '\n';
    }
    return 0;
}