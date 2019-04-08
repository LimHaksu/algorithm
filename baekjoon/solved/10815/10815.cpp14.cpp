#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);cin.tie(0);
    int n, m;
    cin >> n;
    vector<int> cards(n);
    for(int i = 0; i < n; i++){
        cin >> cards[i];
    }
    cin >> m;
    vector<int> number(m);
    for(int i = 0; i < m; i++){
        cin >> number[i];
    }
    sort(cards.begin(), cards.end());
    int left, right, mid;
    bool exist;
    for(int i = 0; i < m; i++){
        left = 0;
        right = n-1;
        exist = false;
        while(left <= right){
            mid = (left + right) / 2;
            if(cards[mid] == number[i]){
                cout << "1 ";
                exist = true;
                break;
            }else if(cards[mid] > number[i]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(exist == false){
            cout << "0 ";
        }
    }
    return 0;
}