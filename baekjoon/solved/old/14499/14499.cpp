#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;
typedef vector<vector<int>> vvi;
typedef vector<int> vi;
const int bottom = 5;
const int top = 0;
void right(vvi& mymap, vi& dice, int& r, int& c) {// x, y는 이동 전 현재 좌표
	if (c < mymap[r].size() - 1) {
		c += 1;
		int temp = dice[3];
		dice[3] = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = temp;
		if (mymap[r][c] == 0) {
			mymap[r][c] = dice[bottom];
		}
		else {
			dice[bottom] = mymap[r][c];
			mymap[r][c] = 0;
		}
		cout << dice[top] << '\n';
	}
}
void left(vvi& mymap, vi& dice, int& r, int& c) {
	if (c > 0) {
		c -= 1;
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = dice[2];
		dice[2] = temp;
		if (mymap[r][c] == 0) {
			mymap[r][c] = dice[bottom];
		}
		else {
			dice[bottom] = mymap[r][c];
			mymap[r][c] = 0;
		}
		cout << dice[top] << '\n';
	}
}
void down(vvi& mymap, vi& dice, int& r, int& c) {
	if (r < mymap.size()-1) {
		r += 1;
		int temp = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = temp;
		if (mymap[r][c] == 0) {
			mymap[r][c] = dice[bottom];
		}
		else {
			dice[bottom] = mymap[r][c];
			mymap[r][c] = 0;
		}
		cout << dice[top] << '\n';
	}
}
void up(vvi& mymap, vi& dice, int& r, int& c) {
	if (r > 0 ) {
		r -= 1;
		int temp = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = dice[0];
		dice[0] = temp;
		if (mymap[r][c] == 0) {
			mymap[r][c] = dice[bottom];
		}
		else {
			dice[bottom] = mymap[r][c];
			mymap[r][c] = 0;
		}
		cout << dice[top] << '\n';
	}
}
int main() {
	freopen("input.txt", "r", stdin);
	int n, m, x, y, k;
	cin >> n >> m >> x >> y >> k;
	vvi mymap(n, vector<int>(m));
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> mymap[i][j];
		}
	}
	vi dice(6, 0);
	int move;
	for (int i = 0; i < k; ++i) {
		cin >> move;
		switch (move) {
		case 1:
			right(mymap, dice, x, y);
			break;
		case 2:
			left(mymap, dice, x, y);
			break;
		case 3:
			up(mymap, dice, x, y);
			break;
		case 4:
			down(mymap, dice,x, y);
			break;
		}
	}
	return 0;
}