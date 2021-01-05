function solution(answers) {
    var answer = [];
    let counts = [0, 0, 0];
    const two = [1, 3, 4, 5];
    const three = [3, 1, 2, 4, 5];
    answers.forEach((answer, idx) => {
        //1번 idx%5 + 1
        if (answer === (idx % 5) + 1) {
            counts[0]++;
        }
        //2번 짝수 2, 홀수 1,3,4,5
        if (idx % 2 === 0 && answer === 2) {
            counts[1]++;
        } else if (idx % 2 === 1 && answer === two[parseInt(idx / 2) % 4]) {
            counts[1]++;
        }
        //3번 3 1 2 4 5
        if (answer === three[parseInt(idx / 2) % 5]) {
            counts[2]++;
        }
    });
    let max = 0;
    console.log(counts);
    for (let i = 0; i < counts.length; ++i) {
        if (counts[i] > max) {
            max = counts[i];
            answer = [i + 1];
        } else if (counts[i] === max) {
            answer.push(i + 1);
        }
    }
    return answer;
}
