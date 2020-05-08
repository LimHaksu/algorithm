#include <iostream>
#include <string>
#include <tuple>
#include <algorithm>
#include <vector>
using namespace std;
typedef tuple<string,int,int,int> mytuple;
bool compare(mytuple a, mytuple b){
    if(get<1>(a) == get<1>(b)){
        if(get<2>(a) == get<2>(b)){
            if(get<3>(a) == get<3>(b))
                return get<0>(a) < get<0>(b);
            return get<3>(a) > get<3>(b);
        }
        return get<2>(a) < get<2>(b);
    }
    return get<1>(a) > get<1>(b);
}
int main(){
    int n;
    cin >> n;
    vector<mytuple> points;
    string name;
    int korean, english, math;
    for(int i = 0; i < n ; i++){
        cin >> name >> korean >> english >> math;
        points.push_back(make_tuple(name,korean,english,math));
    }
    sort(points.begin(), points.end(), compare);
    for(int i = 0; i < n; i++){
        cout << get<0>(points[i]) << "\n";
    }
    return 0;
}