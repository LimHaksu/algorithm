function solution(left, right) {
    var answer = 0;
    for (let i = left; i <= right; ++i) {
        if (countDivisor(i) % 2 === 0) {
            answer += i;
        } else {
            answer -= i;
        }
    }
    return answer;
}

const countDivisor = (num) => {
    let count = 0;
    for (let i = 1; i <= num; ++i) {
        if (num % i === 0) {
            count++;
        }
    }
    return count;
};
