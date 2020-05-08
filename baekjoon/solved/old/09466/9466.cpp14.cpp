#include <iostream>
#include <vector>
#include <stack>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);cin.tie(0);
	int t;
	cin >> t;
	while(t--){
		int n, to;
		cin >> n;
		vector<int> nodes(n+1);
		for(int i = 1; i <= n; ++i){
			cin >> to;
			nodes[i] = to;
		}
		vector<bool> rest(n+1,true);
        vector<bool> avail(n+1,true);
		int count = n;
		for(int start = 1; start <= n; ++start){
			if(rest[start] == true){
				vector<bool> visited(n+1,false);
				vector<int> team;
				team.reserve(n);
				int current = start;
				bool circle = true;
				while(visited[current] == false){
					if(rest[current] && avail[current]){
						team.push_back(current);
						visited[current] = true;
						current = nodes[current];
					}else{
						circle = false;
						break;
					}
				}
				if(circle == true){
					int index = team.size()-1;
					while(team[index] != current){
						rest[team[index]] = false;
						index--;
						count--;
					}
					rest[team[index]] = false;
					index--;
					count--;
				}else{
                    avail[start] = false;
                }
			}
		}
		cout << count << "\n";
	}
	return 0;
}