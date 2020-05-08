#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
int diff(int a, int b){
    if(a > b)
        return a-b;
    else
        return b-a;
}
void assign(vector<vector<int>>& ability, vector<bool>& picked, vector<int>& team_a, int current, int n, int& min){
    if(team_a.size() == n/2){
        vector<int> team_b;
        team_b.reserve(n/2);
        for(int i = 0; i < n; ++i){
            if(!picked[i]){
                team_b.push_back(i);
            }
        }
        int sum_a = 0, sum_b = 0;
        for(int i = 0; i < team_a.size()-1; ++i){
            for(int j = i+1; j < team_a.size(); ++j){
                sum_a += ability[team_a[i]][team_a[j]];
                sum_a += ability[team_a[j]][team_a[i]];
            }
        }
        for(int i = 0; i < team_b.size()-1; ++i){
            for(int j = i+1; j < team_b.size(); ++j){
                sum_b += ability[team_b[i]][team_b[j]];
                sum_b += ability[team_b[j]][team_b[i]];
            }
        }
        if(diff(sum_a,sum_b) < min)
            min = diff(sum_a,sum_b);
    }else{
        for(int i = current+1; i < n; ++i){
            if(!picked[i]){
                picked[i] = true;
                team_a.push_back(i);
                assign(ability,picked,team_a,i,n,min);
                picked[i] = false;
                team_a.pop_back();
            }            
        }
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    vector<vector<int>> ability(n,vector<int>(n));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> ability[i][j];
        }
    }
    int min = 10000000;
    vector<bool> picked(n,false);
    vector<int> team_a;
    for(int i = 0; i < n/2; ++i){
        picked[i] = true;
        team_a.push_back(i);
        assign(ability,picked,team_a,i,n,min);
        picked[i] = false;
        team_a.pop_back();
    }
    cout << min;
    return 0;
}
