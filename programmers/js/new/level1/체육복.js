function solution(n, lost, reserve) {
    var answer = 0;
    const students = Array.from(Array(n + 1), () => 1);
    lost.forEach((num) => {
        students[num]--;
    });
    const check = Array.from(Array(n + 1), () => false);
    reserve.forEach((num) => {
        if (students[num] === 0) {
            students[num]++;
            check[num] = true;
        }
    });
    reserve.forEach((num) => {
        if (!check[num]) {
            if (students[num - 1] === 0) {
                students[num - 1]++;
            } else if (num < n && students[num + 1] === 0) {
                students[num + 1]++;
            }
        }
    });
    for (let i = 1; i <= n; ++i) {
        if (students[i] >= 1) {
            answer++;
        }
    }
    return answer;
}
