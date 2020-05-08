#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int main(){
    int n,m;
    scanf("%d", &n);
    vector<int> cards_map(20000001,0);
    vector<int> cards(n);
    int temp;
    int min = 20000000, max = 0; // -10000000
    for(int i = 0; i < n; i++){
        scanf("%d", &temp);
        temp += 10000000;
        if(temp < min)
            min = temp;
        if(temp > max)
            max = temp;
        cards_map[temp]++;
        cards[i] = temp;
    }
    sort(cards.begin(), cards.end());
    scanf("%d", &m);
    int left, right, mid;
    bool exist;
    for(int i = 0; i < m; i++){
        left = min;
        right = max;
        scanf("%d", &temp);
        temp += 10000000;
        exist = false;
        while(left <= right){
            mid = (left + right) / 2;
            if(mid == temp){
                printf("%d ",cards_map[temp]);
                exist = true;
                break;
            }else if(mid < temp){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(exist == false){
            printf("0 ");
        }
    }
    return 0;
}