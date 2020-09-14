function solution(numbers) {
    var answer = [];
    const set = new Set();
    numbers.forEach((n1, i) => {
        numbers.forEach((n2, j) => {
            if (i != j) {
                set.add(n1 + n2);
            }
        })
    })
    set.forEach((number) => {
        answer.push(number);
    })
    answer.sort((a, b) => (a - b));
    return answer;
}