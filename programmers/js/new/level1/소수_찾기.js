function solution(n) {
    var answer = 0;
    const check = Array.from(Array(n + 1), () => true);
    for (let i = 2; i < check.length; ++i) {
        if (check[i]) {
            answer++;
            for (let j = i; j < check.length; j += i) {
                check[j] = false;
            }
        }
    }
    return answer;
}
