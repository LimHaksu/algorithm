function solution(N, stages) {
    var answer = [];
    for (let i = 0; i < N; ++i) {}
    const arriveCount = Array(N + 2).fill(0);
    stages.forEach((stage) => {
        arriveCount[stage]++;
    });
    let acc = arriveCount[N + 1];
    for (let i = N; i >= 1; --i) {
        acc += arriveCount[i];
        const failure = arriveCount[i] / acc;
        answer.push({ stage: i, failure });
    }
    answer.sort((a, b) => {
        if (a.failure > b.failure) {
            return -1;
        } else if (a.failure < b.failure) {
            return 1;
        }
        return a.stage - b.stage;
    });
    return answer.map((e) => e.stage);
}
