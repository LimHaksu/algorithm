function solution(numbers) {
    var answer = [];
    const set = new Set();
    for (let i = 0; i < numbers.length; ++i) {
        for (let j = i + 1; j < numbers.length; ++j) {
            set.add(numbers[i] + numbers[j]);
        }
    }
    set.forEach((number) => {
        answer.push(number);
    });
    answer.sort((a, b) => a - b);
    return answer;
}
