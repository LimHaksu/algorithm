function solution(array, commands) {
    var answer = [];
    commands.forEach((command) => {
        const i = command[0] - 1;
        const j = command[1] - 1;
        const k = command[2] - 1;
        const tempArr = [];
        for (let idx = i; idx <= j; ++idx) {
            tempArr.push(array[idx]);
        }
        tempArr.sort((a, b) => a - b);
        answer.push(tempArr[k]);
    });
    return answer;
}
