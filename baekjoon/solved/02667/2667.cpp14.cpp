#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <string>
using namespace std;
bool boundary_check(int n, int x, int y){
    if(x>=0 && x < n && y>=0 && y < n)
        return true;
    return false;
}
int main(){
    int n;
    cin >> n;
    vector<vector<int>> location(n,vector<int>(n));
    string line;
    for(int i = 0; i < n; ++i){
    	cin >> line;
        for(int j = 0; j < n; ++j){
            location[i][j] = line[j]-'0';
        }
    }
    vector<vector<int>> visited(n,vector<int>(n,false));
    vector<int> current(2);
    vector<int> count;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(location[i][j] && !visited[i][j]){
                count.push_back(0);
                current[0] = i;
                current[1] = j;
                stack<vector<int>> s;
                s.push(current);
                vector<int> temp(2);
                while(!s.empty()){
                	current = s.top();
                    s.pop();
                    if(!visited[current[0]][current[1]]){
                    	count[count.size()-1]++;
                    	visited[current[0]][current[1]] = true;
                        temp[0] = current[0]-1;
                        temp[1] = current[1];
                        if(boundary_check(n,temp[0],temp[1]) && location[temp[0]][temp[1]]
                           && !visited[temp[0]][temp[1]]){
                             s.push(temp);
                        }
                        temp[0] = current[0]+1;
                        temp[1] = current[1];
                        if(boundary_check(n,temp[0],temp[1]) && location[temp[0]][temp[1]]
                           && !visited[temp[0]][temp[1]]){
                             s.push(temp);
                        }
                        temp[0] = current[0];
                        temp[1] = current[1]-1;
                        if(boundary_check(n,temp[0],temp[1]) && location[temp[0]][temp[1]]
                           && !visited[temp[0]][temp[1]]){
                             s.push(temp);
                        }
                        temp[0] = current[0];
                        temp[1] = current[1]+1;
                        if(boundary_check(n,temp[0],temp[1]) && location[temp[0]][temp[1]]
                           && !visited[temp[0]][temp[1]]){
                             s.push(temp);
                        }
                    }
                }
            }
        }   
    }
    sort(count.begin(), count.end());
    cout << count.size() << '\n';
    for(int i = 0; i < count.size(); ++i){
        cout << count[i] << '\n';
    }
    return 0;
}