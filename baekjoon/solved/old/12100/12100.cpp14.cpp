#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
int num_max = 0;
void move_left(vvi& arr){
    for(int i = 0; i < arr.size(); ++i){
        int prev = 0;
        for(int j = 1; j < arr[i].size(); ++j){
            if(arr[i][j] == arr[i][prev]){
                arr[i][prev] *= 2;
                arr[i][j] = 0;
                while(++j < arr[i].size()){
                    if(arr[i][j]!=0){
                        prev = j;
                        break;
                    }
                }
            }else if(arr[i][j] != 0){
                prev = j;
            }
        }
    }
    for(int i = 0; i < arr.size(); ++i){
        int count_zero = 0;
        for(int j = 0; j < arr[i].size(); ++j){
            if(arr[i][j] == 0){
                count_zero++;
            }else if(count_zero > 0){
                arr[i][j-count_zero] = arr[i][j];
                arr[i][j] = 0;
            }
        }
    }
}
void move_right(vvi& arr){
    for(int i = 0; i < arr.size(); ++i){
        int prev = arr[i].size()-1;
        for(int j = arr[i].size()-2; j >= 0; --j){
            if(arr[i][j] == arr[i][prev]){
                arr[i][prev] *= 2;
                arr[i][j] = 0;
                while(--j >= 0){
                    if(arr[i][j]!=0){
                        prev = j;
                        break;
                    }
                }
            }
            else if(arr[i][j] != 0){
                prev = j;
            }
        }
    }
    for(int i = 0; i < arr.size(); ++i){
        int count_zero = 0;
        for(int j = arr[i].size() -1; j >= 0; --j){
            if(arr[i][j] == 0){
                count_zero++;
            }else if(count_zero > 0){
                arr[i][j+count_zero] = arr[i][j];
                arr[i][j] = 0;
            }
        }
    }
}
void move_down(vvi& arr){
    for(int j = 0; j < arr.size(); ++j){
        int prev = arr.size()-1;
        for(int i = arr.size()-2; i >= 0; --i){
            if(arr[i][j] == arr[prev][j]){
                arr[prev][j] *= 2;
                arr[i][j] = 0;       
                while(--i >= 0){
                    if(arr[i][j]!=0){
                        prev = i;
                        break;
                    }
                }
            }else if(arr[i][j] != 0){
                prev = i;
            }
        }
    }
    for(int j = 0; j < arr.size(); ++j){
        int count_zero = 0;
        for(int i = arr.size()-1; i >= 0; --i){
            if(arr[i][j] == 0){
                count_zero++;
            }else if(count_zero > 0){
                arr[i+count_zero][j] = arr[i][j];
                arr[i][j] = 0;
            }
        }
    }
}
void move_up(vvi& arr){
    for(int j = 0; j < arr.size(); ++j){
        int prev = 0;
        for(int i = 1; i < arr.size(); ++i){
            if(arr[i][j] == arr[prev][j]){
                arr[prev][j] *= 2;
                arr[i][j] = 0;       
                while(++i < arr.size()){
                    if(arr[i][j]!=0){
                        prev = i;
                        break;
                    }
                }
            }else if(arr[i][j] != 0){
                prev = i;
            }
        }
    }
    for(int j = 0; j < arr.size(); ++j){
        int count_zero = 0;
        for(int i = 0; i < arr.size(); ++i){
            if(arr[i][j] == 0){
                count_zero++;
            }else if(count_zero > 0){
                arr[i-count_zero][j] = arr[i][j];
                arr[i][j] = 0;
            }
        }
    }
}
int find_max(vvi& arr){
    int max = 0;
    for(int i = 0; i < arr.size(); ++i){
        for(int j = 0; j < arr[i].size(); ++j){
            if(arr[i][j] > max)
                max = arr[i][j];
        }
    }
    return max;
}
void dfs(vvi& arr,int count){
    if(count == 5){
        int temp_max = find_max(arr);
        if(temp_max > num_max){
            num_max = temp_max;
        }
        return;
    }else{
        vvi temp = arr;
        move_left(temp);
        dfs(temp,count+1);
        temp = arr;
        move_right(temp);
        dfs(temp,count+1);
        temp = arr;
        move_down(temp);
        dfs(temp,count+1);
        temp = arr;
        move_up(temp);
        dfs(temp,count+1);
        return;
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    vvi arr(n,vi(n));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> arr[i][j];
        }
    }
    int count = 0;
    dfs(arr,0);
    cout << num_max;
    return 0;
}