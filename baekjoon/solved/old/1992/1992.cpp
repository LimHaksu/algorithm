#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;
string qt(vvi& arr, int r_start, int c_start, int size){
    bool check = true;
    int ref = arr[r_start][c_start];
    for(int i = r_start; i < r_start+size; ++i){
        for(int j = c_start; j < c_start+size; ++j){
            if(arr[i][j] != ref){
                check = false;
                break;
            }
        }
    }
    if(check){
        string s = "";
        s += ref;
        return s;
    }
    string return_string = "(";
    return_string += qt(arr,r_start,c_start,size/2);
    return_string += qt(arr,r_start,c_start+size/2,size/2);
    return_string += qt(arr,r_start+size/2,c_start,size/2);
    return_string += qt(arr,r_start+size/2,c_start+size/2,size/2);
    return return_string+")";
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    vvi arr(n,vi(n));
    string line;
    for(int i = 0; i < n; ++i){
        cin >> line;
        for(int j = 0; j < n; ++j){
            arr[i][j] = line[j];
        }
    }
    string answer = qt(arr,0,0,n);
    cout << answer;
    return 0;
}