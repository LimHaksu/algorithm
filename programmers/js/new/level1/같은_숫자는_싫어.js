function solution(arr) {
    const answer = [];
    arr.forEach((num) => {
        if (answer[answer.length - 1] !== num || answer.length === 0) {
            answer.push(num);
        }
    });
    return answer;
}
