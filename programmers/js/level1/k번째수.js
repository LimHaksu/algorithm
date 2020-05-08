function solution(array, commands) {
    var answer = [];
    for (let i = 0; i < commands.length; ++i) {
        const from = commands[i][0] - 1;
        const to = commands[i][1];
        const k = commands[i][2] - 1;
        let temp = [];
        for (let j = from; j < to; ++j) {
            temp.push(array[j]);
        }
        temp.sort((a, b) => {
            return a - b;
        })
        answer.push(temp[k]);
    }
    return answer;
}

console.log(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]));