function solution(n, a, b) {
    var answer = 0;
    while (a > 0) {
        answer++;
        if (areTheyMeet(a, b)) {
            break;
        }
        a = parseInt((a + 1) / 2);
        b = parseInt((b + 1) / 2);
    }
    return answer;
}

function areTheyMeet(a, b) {
    if (a > b) {
        const temp = a;
        a = b;
        b = temp;
    }
    return b - a === 1 && a % 2 === 1 && b % 2 === 0;
}

console.log(solution(8, 4, 7));
