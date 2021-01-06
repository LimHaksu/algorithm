function solution(x, n) {
    var answer = [];
    for (let i = 0; i < n; ++i) {
        answer.push(x * (i + 1));
    }
    return answer;
}
