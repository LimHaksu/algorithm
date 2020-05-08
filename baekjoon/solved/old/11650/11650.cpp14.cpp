#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
class point{
  public:
    int x;
    int y;
    point(int x, int y){
        this->x = x;
        this->y = y;
    }
    bool operator<(point& p){
        if(this->x == p.x)
            return this->y < p.y;
        return this->x < p.x;
    }
};
int main(){
    ios_base:: sync_with_stdio(false); 
    int n;
    cin >> n;
    vector<point> points(n,point(0,0));
    for(int i = 0; i < n; i++){
        cin >> points[i].x >> points[i].y;
    }
    sort(points.begin(), points.end());
    for(int i = 0; i < n; i++){
        cout << points[i].x << " " << points[i].y << "\n";
    }
}