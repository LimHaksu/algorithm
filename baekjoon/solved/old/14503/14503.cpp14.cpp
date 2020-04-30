#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
void clean(vector<vector<int>>& room, int current_r, int current_c, int direction, int& count);
bool boundary_check(vector<vector<int>>& room, int r, int c){
    if(r < 0 || r >= room.size() || c < 0 || c >= room[0].size())
        return false;
    return true;
}
bool left_check(vector<vector<int>>& room, int current_r, int current_c, int direction){
    switch(direction){
        case 0:  // 북
            if(boundary_check(room,current_r,current_c-1) && room[current_r][current_c-1] == 0)
                return true;
            break;                
        case 1:  // 동
            if(boundary_check(room,current_r-1,current_c) && room[current_r-1][current_c] == 0)
                return true;
            break;
        case 2:  // 남
            if(boundary_check(room,current_r,current_c+1) && room[current_r][current_c+1] == 0)
                return true;
            break;
        case 3:  // 서
            if(boundary_check(room,current_r+1,current_c) && room[current_r+1][current_c] == 0)
                return true;
            break;
    }
    return false;
}
bool right_check(vector<vector<int>>& room, int current_r, int current_c, int direction){
    switch(direction){
        case 0:  // 북
            if(boundary_check(room,current_r,current_c+1) && room[current_r][current_c+1] == 0)
                return true;
            break;                
        case 1:  // 동
            if(boundary_check(room,current_r+1,current_c) && room[current_r+1][current_c] == 0)
                return true;
            break;
        case 2:  // 남
            if(boundary_check(room,current_r,current_c-1) && room[current_r][current_c-1] == 0)
                return true;
            break;
        case 3:  // 서
            if(boundary_check(room,current_r-1,current_c) && room[current_r-1][current_c] == 0)
                return true;
            break;
    }
    return false;
}
bool front_check(vector<vector<int>>& room, int current_r, int current_c, int direction){
    switch(direction){
        case 0:  // 북
            if(boundary_check(room,current_r-1,current_c) && room[current_r-1][current_c] == 0)
                return true;
            break;                
        case 1:  // 동
            if(boundary_check(room,current_r,current_c+1) && room[current_r][current_c+1] == 0)
                return true;
            break;
        case 2:  // 남
            if(boundary_check(room,current_r+1,current_c) && room[current_r+1][current_c] == 0)
                return true;
            break;
        case 3:  // 서
            if(boundary_check(room,current_r,current_c-1) && room[current_r][current_c-1] == 0)
                return true;
            break;
    }
    return false;
}
bool back_check(vector<vector<int>>& room, int current_r, int current_c, int direction){
    switch(direction){
        case 0:  // 북
            if(boundary_check(room,current_r+1,current_c) && room[current_r+1][current_c] == 0)
                return true;    
            break;            
        case 1:  // 동
            if(boundary_check(room,current_r,current_c-1) && room[current_r][current_c-1] == 0)
                return true;
            break;
        case 2:  // 남
            if(boundary_check(room,current_r-1,current_c) && room[current_r-1][current_c] == 0)
                return true;
            break;
        case 3:  // 서
            if(boundary_check(room,current_r,current_c+1) && room[current_r][current_c+1] == 0)
                return true;
            break;
    }
    return false;
}
bool back_wall_check(vector<vector<int>>& room, int current_r, int current_c, int direction){
    switch(direction){
        case 0:  // 북
            if(boundary_check(room,current_r+1,current_c) && room[current_r+1][current_c] == 1)
                return true;    
            break;            
        case 1:  // 동
            if(boundary_check(room,current_r,current_c-1) && room[current_r][current_c-1] == 1)
                return true;
            break;
        case 2:  // 남
            if(boundary_check(room,current_r-1,current_c) && room[current_r-1][current_c] == 1)
                return true;
            break;
        case 3:  // 서
            if(boundary_check(room,current_r,current_c+1) && room[current_r][current_c+1] == 1)
                return true;
            break;
    }
    return false;
}
void move(vector<vector<int>>&room, int& current_r, int& current_c, int direction){
    switch(direction){
        case 0:  // 북
            current_r--;
            return;             
        case 1:  // 동
            current_c++;
            return;
        case 2:  // 남
            current_r++;
            return;
        case 3:  // 서
            current_c--;
    }
    return;
}
void turn_left(int& direction){
    direction--;
    if(direction < 0)
        direction = 3;
}
void explore(vector<vector<int>>& room, int current_r, int current_c, int direction, int& count){
    if(left_check(room,current_r,current_c,direction)){
        turn_left(direction);
        move(room,current_r,current_c,direction);
        clean(room,current_r,current_c,direction,count);
    }else{
        if(right_check(room,current_r,current_c,direction) || front_check(room,current_r,current_c,direction)
        || back_check(room,current_r,current_c,direction)){
            turn_left(direction);
            explore(room,current_r,current_c,direction,count);
        }else{
            if(back_wall_check(room,current_r,current_c,direction)){
                return;
            }else{
                move(room,current_r,current_c,(direction+2)%4);
                explore(room,current_r,current_c,direction,count);
            }
        }
    }
    return;
}
void clean(vector<vector<int>>& room, int current_r, int current_c, int direction, int& count){
    count++;
    room[current_r][current_c] = 2; // 청소 체크
    explore(room,current_r,current_c,direction,count);
}
int main(){
    freopen("input.txt","r",stdin);
    int n,m;
    cin >> n >> m;
    int current_r, current_c, direction;
    cin >> current_r >> current_c >> direction;
    vector<vector<int>> room(n,vector<int>(m));
    for(int i = 0; i < n ; ++i){
        for(int j = 0; j < m ; ++j){
            cin >> room[i][j];
        }
    }
    int count = 0;
    clean(room,current_r,current_c,direction,count);
    cout << count;
    return 0;
}