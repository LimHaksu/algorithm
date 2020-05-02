function solution(participant, completion) {
    var answer = '';
    let map = {};
    participant.forEach(e => {
        if (!map[e]) {
            map[e] = 1;
        } else {
            map[e]++;
        }
    })
    completion.forEach(e => {
        map[e]--;
    })
    for (let key in map) {
        if (map[key] > 0) {
            answer = key;
        }
    }
    return answer;
}

console.log(solution(['leo', 'kiki', 'eden'], ['eden', 'kiki']));