#include <iostream>
#include <cstdio>
#include <vector>
#include <string>
#include <utility>

using namespace std;
typedef pair<int, int> iipair;
int right_rotation(int index) { // 시계방향
	return (index + 7) % 8;
}
int left_rotation(int index) { // 반시계방향
	return (index + 1) % 8;
}
void rotate(string* gear,int i, int* index, int direction, int spread) {
	if (i == 0) {
		if (spread == 0 && gear[i+1][(index[i+1] + 6) % 8] != gear[i][(index[i] + 2) % 8]) {
			rotate(gear, i+1, index, -direction, 1);
		}
		if (direction == 1) {
			index[i] = right_rotation(index[i]);
		}
		else {
			index[i] = left_rotation(index[i]);
		}
	}else if (i == 3) {
		if (spread == 0 && gear[i][(index[i] + 6) % 8] != gear[i-1][(index[i-1] + 2) % 8]) {
			rotate(gear, i-1, index, -direction, 2);
		}	
		if (direction == 1) {
			index[i] = right_rotation(index[i]);
		}
		else {
			index[i] = left_rotation(index[i]);
		}
	}else if(i == 1 || i == 2) {
		if ((spread == 0 || spread == 1) && gear[i + 1][(index[i+1] + 6) % 8] != gear[i][(index[i] + 2) % 8]) {
			rotate(gear, i + 1, index, -direction, 1);
		}
		if ((spread == 0 || spread == 2) && gear[i][(index[i] + 6) % 8] != gear[i - 1][(index[i-1] + 2) % 8]) {
			rotate(gear, i - 1, index, -direction, 2);
		}
		if (direction == 1) {
			index[i] = right_rotation(index[i]);
		}
		else {
			index[i] = left_rotation(index[i]);
		}
	}
}
int main() {
	freopen("input.txt", "r", stdin);
	string gear[4];
	int index[4] = { 0 }; // 12시 index
	for (int i = 0; i < 4; ++i) {
		cin >> gear[i];
	}
	int k;
	cin >> k;
	vector<iipair> rotation(k);
	int num, direction; // d 1 시계, -1 반시계
	for (int i = 0; i < k; ++i) {
		cin >> num >> direction;
		rotate(gear, num-1, index, direction, 0);
	}
	int current_score = 1;
	int total = 0;
	for (int i = 0; i < 4; ++i) {
		if (gear[i][index[i]] == '1') {
			total += current_score;
		}
		current_score *= 2;
	}
	cout << total;
	return 0;
}