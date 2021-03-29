function solution(n) {
    return hanoi(1, 3, 2, n);
}

function hanoi(from, to, stopOver, level) {
    if (level === 1) {
        return [[from, to]];
    }
    return [...hanoi(from, stopOver, to, level - 1), [from, to], ...hanoi(stopOver, to, from, level - 1)];
}

console.log(solution(3));
