#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;
int main(){
    int n;
    ll m;
    cin >> n >> m;
    vector<int> trees(n);
    int max = 0;
    for(int i = 0; i < n; i++){
        cin >> trees[i];
        if(trees[i] > max)
            max = trees[i];
    }
    int left = 0;
    int right = max;
    int mid;
    int answer = 0;
    ll sum;
    while(left <= right){
        sum = 0;
        mid = (left + right) / 2;
        for(int i = 0; i < n; i++){
            if(trees[i] > mid)
            	sum += trees[i]-mid;
        }
        if(sum >= m){
            left = mid + 1;
            if(mid > answer)
                answer = mid;
        }else{
            right = mid - 1;
        }
    }
    cout << answer;
    return 0;
}