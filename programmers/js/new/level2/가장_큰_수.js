function solution(numbers) {
    numbers.sort((a, b) => {
        const first = parseInt("" + a + b);
        const second = parseInt("" + b + a);
        if (first > second) {
            return -1;
        } else {
            return 1;
        }
    });
    const answer = numbers.join("");
    return answer[0] === "0" ? "0" : answer;
}

console.log(solution([6, 10, 2]));
console.log(solution([3, 30, 34, 5, 9]));
