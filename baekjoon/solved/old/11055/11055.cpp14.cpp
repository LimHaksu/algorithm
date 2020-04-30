#include <iostream>

int main()
{
	using namespace std;
	int input;
	int a[1001] = { 0, };
	int d[1001] = { 0, };
	int result = 0;

	cin >> input; // 수열의 개수 입력
	for (int i = 0; i < input; i++) {
		cin >> a[i]; // 수열 입력
		d[i] = a[i];
		for (int j = 0; j < i; j++) {
			if (a[i] > a[j] && d[i] < d[j] + a[i]) // 증가하는 수열일 경우 && 
							       // 현재의 비교 대상 값보다 
							       // 이전까지의 합 + 현재 값이 더 클경우
				d[i] = d[j] + a[i]; // 이전까지의 합과 현재 값을 더해 넣어준다
		}
		if (d[i] > result) // 현재 계산된 합이 이전의 값보다 클 경우
			result = d[i]; // 값을 현재 계산된 합으로 대체한다
	}
	cout << result << endl; // 답 출력
}