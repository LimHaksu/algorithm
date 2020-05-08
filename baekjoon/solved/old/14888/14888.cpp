#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;
int main()
{
    freopen("input.txt", "r", stdin);
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i){
        cin >> arr[i];
    }
    int plus, minus, multiply, divide;
    cin >> plus >> minus >> multiply >> divide;
    vector<char> op;
    op.reserve(plus+minus+multiply+divide);
    for (int i = 0; i < plus; ++i){
        op.push_back('p');
    }
    for (int i = 0; i < minus; ++i){
        op.push_back('m');
    }
    for (int i = 0; i < multiply; ++i){
        op.push_back('t');
    }
    for (int i = 0; i < divide; ++i){
        op.push_back('d');
    }
    int max = -1000000000;
    int min = 1000000000;
    sort(op.begin(),op.end());
    do{
        int result = arr[0];    
        for (int i = 0; i < op.size(); ++i){
            switch (op[i]){
            case 'p':
                result += arr[i + 1];
                break;
            case 'm':
                result -= arr[i + 1];
                break;
            case 't':
                result *= arr[i + 1];
                break;
            case 'd':
                result /= arr[i + 1];
                break;
            }
        }
        if (result > max)
            max = result;
        if (result < min)
            min = result;
    } while (next_permutation(op.begin(), op.end()));
    cout << max << '\n' << min;
    return 0;
}