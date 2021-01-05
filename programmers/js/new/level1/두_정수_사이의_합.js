function solution(a, b) {
    if (a > b) {
        const temp = a;
        a = b;
        b = temp;
    }
    var answer = 0;
    for (let i = a; i <= b; ++i) {
        answer += i;
    }
    return answer;
}
