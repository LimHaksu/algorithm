// 1~ 5번 cctv 좌표 저장 vector<vector<int>> 번호,r,c
// 1번은 네 방향 각각 dfs
// 2번은 두 방향 각각 dfs
// 3번은 네 방향 각각 dfs
// 4번은 네 방향 각각 dfs
// 5번은 한 방향 dfs
#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
void print(vvi& room){
    for(int i = 0 ; i < room.size() ; ++i){
        for(int j = 0; j < room[i].size(); ++j){
            cout << room[i][j] << ",";
        }
        cout << "\n";
    }
    cout << "\n";
}
int count_empty(vvi& room){
    int count = 0;
    for(int i = 0; i < room.size(); ++i){
        for(int j = 0; j < room[i].size(); ++j){
            if(room[i][j] == 0)
                count++;
        }
    }
    return count;
}
void cctv1(vvi& room, int direction, int r, int c){
    switch(direction){
        case 0:
            while((--r) >= 0 &&  room[r][c] != 6){
                if(room[r][c] == 0)
                    room[r][c] = 7; 
            }
        break;
        case 1:
            while((++c) < room[r].size() &&  room[r][c] != 6){
                if(room[r][c] == 0)
                    room[r][c] = 7; 
            }
        break;
        case 2:
            while((++r) < room.size() &&  room[r][c] != 6){
                if(room[r][c] == 0)
                    room[r][c] = 7; 
            }        
        break;
        case 3:
            while((--c) >= 0 &&  room[r][c] != 6){
                if(room[r][c] == 0)
                    room[r][c] = 7; 
            }
        break;
    }
}
void cctv2(vvi& room, int direction, int r, int c){
    switch(direction){
        int c_tmp, r_tmp;
        case 0:
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
        break;
        case 1:
            r_tmp = r;
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }              
        break;
    }
}
void cctv3(vvi& room, int direction, int r, int c){
    switch(direction){
        int r_tmp, c_tmp;
        case 0:
            r_tmp = r;
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            } 
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
        break;
        case 1:
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
            r_tmp = r;
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            } 
        break;
        case 2:
            r_tmp = r;
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }  
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }      
        break;
        case 3:
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
            r_tmp = r;
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
        break;
    }    
}
void cctv4(vvi& room, int direction, int r, int c){
    switch(direction){
        int r_tmp, c_tmp;
        case 0:
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }    
            r_tmp = r;        
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }  
        break;
        case 1:
            r_tmp = r;  
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            r_tmp = r; 
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
        break;
        case 2:
            r_tmp = r; 
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
            c_tmp = c;
            while((--c_tmp) >= 0 &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }        
        break;
        case 3:
            r_tmp = r; 
            while((--r_tmp) >= 0 &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
            c_tmp = c;
            while((++c_tmp) < room[r].size() &&  room[r][c_tmp] != 6){
                if(room[r][c_tmp] == 0)
                    room[r][c_tmp] = 7; 
            }
            r_tmp = r; 
            while((++r_tmp) < room.size() &&  room[r_tmp][c] != 6){
                if(room[r_tmp][c] == 0)
                    room[r_tmp][c] = 7; 
            }
        break;
    }
}
void cctv5(vvi& room,int r, int c){
    int r_tmp, c_tmp;
    r_tmp = r;
    while ((--r_tmp) >= 0 && room[r_tmp][c] != 6){
        if (room[r_tmp][c] == 0)
            room[r_tmp][c] = 7;
    }
    c_tmp = c;
    while ((++c_tmp) < room[r].size() && room[r][c_tmp] != 6){
        if (room[r][c_tmp] == 0)
            room[r][c_tmp] = 7;
    }
    r_tmp = r;
    while ((++r_tmp) < room.size() && room[r_tmp][c] != 6){
        if (room[r_tmp][c] == 0)
            room[r_tmp][c] = 7;
    }
    c_tmp = c;
    while ((--c_tmp) >= 0 && room[r][c_tmp] != 6){
        if (room[r][c_tmp] == 0)
            room[r][c_tmp] = 7;
    }
}
void dfs(vvi& room, vvi& cctv, int index, int& mymin){
    int count;
    if(index == cctv.size()){
        count = count_empty(room);
        //print(room);
        //cout << count << endl;
        if(count < mymin)
            mymin = count;
        return;
    }
    vvi temp;
    switch(cctv[index][0]){
        case 1:
            temp = room;
            cctv1(temp,0,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv1(temp,1,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv1(temp,2,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv1(temp,3,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            break;
        case 2:
            temp = room;
            cctv2(temp,0,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv2(temp,1,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            break;
        case 3:
            temp = room;
            cctv3(temp,0,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv3(temp,1,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv3(temp,2,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv3(temp,3,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            break;
        case 4:
            temp = room;
            cctv4(temp,0,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv4(temp,1,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv4(temp,2,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            temp = room;
            cctv4(temp,3,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            break;
        case 5:            
            temp = room;
            cctv5(temp,cctv[index][1],cctv[index][2]);
            dfs(temp,cctv,index+1,mymin);
            break;
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n, m;
    cin >> n >> m;
    vvi room(n,vi(m));
    vvi cctv;
    for(int i = 0 ; i < n; ++i){
        for(int j = 0; j < m; ++j){
            cin >> room[i][j];
            if(room[i][j] != 0 && room[i][j] != 6){
                cctv.push_back(vi(1,room[i][j]));
                cctv[cctv.size()-1].push_back(i);
                cctv[cctv.size()-1].push_back(j);
            }
        }
    }
    int mymin = n*m;
    dfs(room,cctv,0,mymin);
    cout << mymin;
    return 0;
}