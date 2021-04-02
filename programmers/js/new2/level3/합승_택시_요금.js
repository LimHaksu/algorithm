function solution(n, s, a, b, fares) {
    var answer = Number.MAX_SAFE_INTEGER;
    const map = Array.from(Array(n + 1), (_, i) =>
        Array.from(Array(n + 1), (_, j) => (i === j ? 0 : Number.MAX_SAFE_INTEGER))
    );
    fares.forEach((f) => {
        const [from, to, cost] = f;
        map[from][to] = cost;
        map[to][from] = cost;
    });

    for (let k = 1; k <= n; ++k) {
        for (let i = 1; i <= n; ++i) {
            for (let j = 1; j <= n; ++j) {
                map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
            }
        }
    }

    for (let i = 1; i <= n; ++i) {
        answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
    }
    return answer;
}

console.log(
    solution(6, 4, 6, 2, [
        [4, 1, 10],
        [3, 5, 24],
        [5, 6, 2],
        [3, 1, 41],
        [5, 1, 24],
        [4, 6, 50],
        [2, 4, 66],
        [2, 3, 22],
        [1, 6, 25],
    ])
);
