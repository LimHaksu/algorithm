#include <iostream>

#include <algorithm>

using namespace std;

 

const int MAX = 500000;

 

int arr[MAX];

int visited[8001]; //-4000~4000

 

int main(void)

{

        ios_base::sync_with_stdio(0);

        cin.tie(0); //cin 실행속도 향상

        int N;

        cin >> N;

 

        float sum = 0;

        int maxNum = -4000, minNum = 4000;

        for (int i = 0; i < N; i++)

        {

                 cin >> arr[i];

 

                 sum += arr[i];

                 visited[arr[i] + 4000]++;

                 maxNum = max(maxNum, arr[i]);

                 minNum = min(minNum, arr[i]);

        }

        //평균

        float average = sum / N;

        if (average >= 0)

                 cout << int(average + 0.5) << "\n";

        else

                 cout << int(average - 0.5) << "\n";

        //중간값

        sort(arr, arr + N);

        cout << arr[N / 2] << "\n";

        //최빈값

        int num = -1;

        int cur = 0;

        bool second = false;

        for(int i=0; i <= 8000; i++)

                 if (cur < visited[i])

                 {

                         cur = visited[i];

                         num = i;

                         second = false;

                 }

                 else if (cur == visited[i] && !second)

                 {

                         num = i;

                         second = true;

                 }

        cout << num - 4000 << "\n";

        //최댓값 - 최솟값

        cout << maxNum - minNum << "\n";

        return 0;

}