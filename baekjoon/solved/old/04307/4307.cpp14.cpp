#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int min(int a, int b){
    return a < b ? a : b;
}
int max(int a, int b){
    return a > b ? a : b;
}
int main(){
    int t;
    cin >> t;
    while(t-- > 0){
        int l, n;
        cin >> l >> n;
        vector<int> ants(n+2);
        for(int i = 1; i <= n; i++){
            cin >> ants[i];
        }
        ants[0] = 0;
        ants[n+1] = l;
        sort(ants.begin(), ants.end());
        vector<int> distances(n+1);
        for(int i = 0; i < n+1; i++){
            distances[i] = ants[i+1] - ants[i]; 
        }
        int min_num =0 , max_num = 0;
        if(n==1){
            min_num = min(distances[0],distances[1]);
            max_num = max(distances[0], distances[1]);
        }else{
        	for(int i = 1; i <= n; i++){
        		int temp = min(ants[i],l-ants[i]);
        		min_num = min_num > temp ? min_num : temp;
        	}
            int middle_sum = 0;
            for(int i = 1; i < n; i++){
                middle_sum += distances[i];
            }
            max_num = max(middle_sum+distances[0], middle_sum+distances[n]);
        }
        cout << min_num << " " << max_num << "\n";
    }
    return 0;
}