#include <iostream>
#include <vector>
#include <utility>
#include <deque>
#include <cstdio>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
typedef pair<int,int> pii;
typedef deque<pii> dqpii;
int dr[4] = {0,1,0,-1};
int dc[4] = {1,0,-1,0};
int check(vvi& board, int cr, int cc){
    if(cr < 0 || cr >= board.size() || cc < 0 || cc >= board.size())
        return -1;
    if(board[cr][cc] == 1)
        return -1;
    if(board[cr][cc] == 2)
        return 2;
    return 0;
}
void change_direction(int& direction, char input){
    if(input == 'D'){
        direction = (direction + 1)%4;
    }else{
        direction = (direction +3)%4; 
    }
}
void move(vvi& board, dqpii& snake, int direction, int& r, int& c){
    r += dr[direction];
    c += dc[direction];  
    if(check(board,r,c) == 0){
        board[snake.back().first][snake.back().second] = 0;
        snake.pop_back();
    }
    board[r][c] = 1;
    snake.push_front(make_pair(r,c));
}
int main(){
    freopen("input.txt","r",stdin);
    int n, k;
    cin >> n >> k;
    vvi board(n,vi(n,0)); // 0 빈공간, 1 뱀, 2 사과
    int t1, t2;
    dqpii snake;
    for(int i = 0 ; i < k; ++i){
        cin >> t1 >> t2;
        board[t1-1][t2-1] = 2;
    }
    int l;
    cin >> l;
    vector<pair<int,char>> direction_vector;
    int direction_index = 0;
    char t3;
    for(int i = 0; i < l; ++i){
        cin >> t1 >> t3;
        direction_vector.push_back(make_pair(t1,t3));
    }
    int direction = 0;
    int r = 0, c = 0;
    board[r][c] = 1;
    snake.push_back(make_pair(r,c));
    int t;
    for(t = 1; t <= 10000; ++t){
        if(check(board,r+dr[direction],c+dc[direction]) != -1){
            move(board,snake,direction, r,c);
            if(direction_vector[direction_index].first == t){
                change_direction(direction,direction_vector[direction_index].second);
                direction_index++;
            }
        }else{
            break;
        }                
    }
    cout << t;
    return 0;
}