#include <iostream>
#include <vector>
using namespace std;
//바이러스 퍼뜨리기
void dfs(vector<vector<int>>& arr, int r, int c) {
	if (r < 0 || r >= arr.size() || c < 0 || c >= arr[0].size()) {
		return;
	}
	if (arr[r][c] == 1 || arr[r][c] == 3) {
		return;
	}
	arr[r][c] = 3;
	dfs(arr, r - 1, c);
	dfs(arr, r + 1, c);
	dfs(arr, r, c - 1);
	dfs(arr, r, c + 1);
}
void virus(vector<vector<int>>& arr) {
	for (int i = 0; i < arr.size(); ++i) {
		for (int j = 0; j < arr[0].size(); ++j) {
			if (arr[i][j] == 2) {
				dfs(arr, i, j);
			}
		}
	}
}
//안전영역 갯수 세기
int count_area(vector<vector<int>>&arr) {
	int count = 0;
	for (int i = 0; i < arr.size(); ++i) {
		for (int j = 0; j < arr[0].size(); ++j) {
			if (arr[i][j] == 0)
				count++;
		}
	}
	return count;
}
//벽 세우기
void wall(vector<vector<int>>& arr, int count, int& max) {
    if (count == 3) {
        vector<vector<int>> temp = arr;
        virus(temp);
        int safe = count_area(temp);
        if (safe > max)
            max = safe;
    }
    else{
        for (int i = 0; i < arr.size(); ++i) {
            for (int j = 0; j < arr[0].size(); ++j) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    wall(arr, count+1, max);
                    arr[i][j] = 0;
                }
            }
        }
    }
	return;
}
int main() {
	int n, m;
	cin >> n >> m;
	vector<vector<int>> arr(n,vector<int>(m));
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> arr[i][j];
		}
	}
	int max = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (arr[i][j] == 0) {
				arr[i][j] = 1;
				wall(arr, 1, max);
                arr[i][j] = 0;
			}
		}
	}
	cout << max;
	return 0;
}