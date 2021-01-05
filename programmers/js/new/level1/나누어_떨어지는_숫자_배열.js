function solution(arr, divisor) {
    var answer = [];
    arr.forEach((num) => {
        if (num % divisor === 0) {
            answer.push(num);
        }
    });
    answer.sort((a, b) => a - b);
    if (answer.length === 0) {
        answer.push(-1);
    }
    return answer;
}
