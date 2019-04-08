#include <iostream>
#include <vector>
using namespace std;

void dfs(vector<vector<int>>& world, vector<vector<bool>>& visited, int r, int c){
	if(r<0 || r >= world.size() || c < 0 || c >= world[0].size())
		return;
	if(visited[r][c] || !world[r][c])
		return;
	visited[r][c] = true;
	dfs(world,visited,r-1,c);
	dfs(world,visited,r+1,c);
	dfs(world,visited,r,c-1);
	dfs(world,visited,r,c+1);
	dfs(world,visited,r-1,c-1);
	dfs(world,visited,r-1,c+1);
	dfs(world,visited,r+1,c-1);
	dfs(world,visited,r+1,c+1);
}

int main() {
	while(true){
		int w, h;
		cin >> w >> h;
		if(w == 0 && h == 0)
			break;
		vector<vector<int>> world(h,vector<int>(w));
		vector<vector<bool>> visited(h,vector<bool>(w,false));
		for(int i = 0; i < h; ++i){
			for(int j = 0; j < w; ++j){
				cin >> world[i][j];
			}
		}
		int count = 0;
		for(int i = 0; i < h; ++i){
			for(int j = 0; j <w; ++j){
				if(!visited[i][j] && world[i][j]){
					dfs(world,visited,i,j);
					count++;
				}
			}
		}
		cout << count << '\n';
	}
	return 0;
}