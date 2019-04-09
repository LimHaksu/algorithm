#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
// 다음 길이 같은 높이면 0 오르막 1 내리막 2, 갈 수 없는 경우 -1
int next_c(vector<vector<int>>& arr, int r, int c){
    if(c+1 >= arr[0].size())
        return -1;
    if(arr[r][c] - arr[r][c+1] == -1)
        return 1;
    if(arr[r][c] - arr[r][c+1]  == 1){
        return 2;
    }
    if(arr[r][c] == arr[r][c+1]){
        return 0;
    }
    return -1;
}
// 다음 길이 같은 높이면 0 오르막 1 내리막 2, 갈 수 없는 경우 -1
int next_r(vector<vector<int>>& arr, int r, int c){
    if(r+1 >= arr[0].size())
        return -1;
    if(arr[r][c] - arr[r+1][c] == -1)
        return 1;
    if(arr[r][c] - arr[r+1][c]  == 1){
        return 2;
    }
    if(arr[r][c] == arr[r+1][c]){
        return 0;
    }
    return -1;
}
int main(){
    freopen("input.txt","r",stdin);
    int n, l;
    cin >> n >> l;
    vector<vector<int>> arr(n,vector<int>(n));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> arr[i][j];
        }
    }
    int count = 0;
    for(int i = 0; i < n; ++i){
        int len = 1; // 현재 포함 지나온 같은 높이 길이
        int current = 0;
        int check;
        while((check = next_c(arr,i,current)) != -1){
            if(check == 1){ // 오르막
                if(len >= l){
                    current++;
                    len = 1;
                }else{
                    break;
                }
            }else if(check == 2){ // 내리막
                current++;
                len = 1;
                while(next_c(arr,i,current) == 0){
                    current++;
                    len++;
                }
                if(len >= l){
                    len -= l;
                }else{
                    break;
                }
            }else{ // 평지
                len++;
                current++;
            }
            if(current == arr[i].size()-1)
                count++;
        }
        current = 0;
        len = 1;
        while((check = next_r(arr,current,i)) != -1){
            if(check == 1){ // 오르막
                if(len >= l){
                    current++;
                    len = 1;
                }else{
                    break;
                }
            }else if(check == 2){ // 내리막
                current++;
                len = 1;
                while(next_r(arr,current,i) == 0){
                    current++;
                    len++;
                }
                if(len >= l){
                    len -= l;
                }else{
                    break;
                }
            }else{ // 평지
                len++;
                current++;
            }
            if(current == arr.size()-1)
                count++;
        }
    }
    cout << count;
    return 0;
}