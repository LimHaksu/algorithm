function solution(answers) {
    var answer = [];
    let count = [0, 0, 0];
    let twoAns = [1, 3, 4, 5];
    let threeAns = [3, 1, 2, 4, 5];
    for (let i = 0; i < answers.length; ++i) {
        // 1번 답 i%5 +1 
        const one = i % 5 + 1;
        // 2번 답 i%2==0 -> 2, i/2 -> index [1,3,4,5]
        let two = -1;
        if (i % 2 == 0) {
            two = 2;
        } else {
            two = twoAns[parseInt(i / 2) % 4];
        }
        // 3번 답 i/2 -> index [3,1,2,4,5]
        const three = threeAns[parseInt(i / 2) % 5];
        if (one == answers[i]) count[0]++;
        if (two == answers[i]) count[1]++;
        if (three == answers[i]) count[2]++;
    }
    let max = 0;
    for (let i = 0; i < count.length; ++i) {
        if (count[i] > max) {
            answer = [i + 1];
            max = count[i];
        } else if (count[i] == max) {
            answer.push(i + 1);
        }
    }
    return answer;
}

console.log(solution([1, 2, 3, 4, 5]));