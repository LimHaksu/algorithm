#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
typedef vector<int> vi;
typedef vector<vi> vvi;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};
int rotate(int d){
    return (d+3) % 4;
}
int r;
void move(vvi& location, int& x, int& y, vi& direction, bool& reverse){
    vi temp = direction;
    for(int i = temp.size()-1; i >= 0 ; --i){
        int rotated = rotate(temp[i]);
        if(reverse){
            x -= dx[rotated];
            y -= dy[rotated];
        }else{
            x += dx[rotated];
            y += dy[rotated];
        }
        location[y][x] = true;
        reverse = !reverse;
        direction.push_back(rotated);
    }
}
int main(){
    freopen("input.txt","r",stdin);
    int n;
    cin >> n;
    int x, y, d, g;
    vvi location(101,vi(101,false));
    for(r = 0; r < n; ++r){
        cin >> x >> y >> d >> g;
        bool reverse = false;
        vi direction;
        //g0
        direction.push_back(d);
        location[y][x] = true;
        x += dx[d];
        y += dy[d];
        location[y][x] = true;
        reverse = !reverse;
        //g1 이후
        for(int i = 1; i <= g; ++i){
            move(location, x, y, direction, reverse);
        }
    }
    int count = 0;
        for(int i = 0; i < 100; ++i){
            for(int j = 0; j < 100; ++j){
                if(location[i][j] && location[i+1][j] && location[i][j+1] && location[i+1][j+1]){
                    count++;
                }
            }
        }
    cout << count;
    return 0;
}