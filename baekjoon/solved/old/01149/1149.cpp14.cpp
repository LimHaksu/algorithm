#include <iostream>
#include <vector>
using namespace std;
int min(int a, int b){
	int min = a < b ? a : b;
	return min;
}
int main(){
    int n;
    cin >> n;
    vector<vector<int>> cost(n,vector<int>(3));
    int t1, t2, t3;
    for(int i = 0; i < n; ++i){
        cin >> t1 >> t2 >> t3;
        cost[i][0] = t1; cost[i][1] = t2; cost[i][2] = t3;        
    }
    vector<vector<int>> least_cost(n,vector<int>(3));
    for(int i = 0; i < 3; i++){
        least_cost[0][i] = cost[0][i];
    }
    for(int i = 1; i < n; i++){
        least_cost[i][0] = min(least_cost[i-1][1], least_cost[i-1][2]) + cost[i][0];
        least_cost[i][1] = min(least_cost[i-1][0], least_cost[i-1][2]) + cost[i][1];
        least_cost[i][2] = min(least_cost[i-1][0], least_cost[i-1][1]) + cost[i][2];
    }
    int answer = min(least_cost[n-1][0], least_cost[n-1][1]);
    answer = min(answer, least_cost[n-1][2]);
    cout << answer;
    return 0;
}