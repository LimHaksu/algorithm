function solution(citations) {
    let answer = 0;
    citations.sort((a, b) => b - a);
    citations.forEach((e, i) => {
        answer = Math.max(answer, Math.min(e, i + 1));
    });
    return answer;
}
