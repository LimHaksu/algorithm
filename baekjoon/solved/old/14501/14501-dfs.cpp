#include <iostream>
#include <vector>
#include <cstdio>

using namespace std;
int dfs(vector<int>& t, vector<int>& p, vector<bool> available, int i) {
	int o = 0, x = 0;
	if (i >= t.size()) {
		return 0;
	}
	x = dfs(t, p, available, i + 1);
	if (available[i] == true && t.size() - i >= t[i]) {
		for (int j = 0; j < t[i]; ++j) {
			available[i + j] = false;
		}
		o = p[i] + dfs(t, p, available, i + 1);
	}
	return o > x ? o : x;
}
int main() {
	freopen("input.txt", "r", stdin);
	int n;
	cin >> n;
	vector<bool> available(n, true);
	vector<int> t(n), p(n);
	for (int i = 0; i < n; ++i) {
		cin >> t[i] >> p[i];
	}
	cout << dfs(t, p, available, 0);
	return 0;
}