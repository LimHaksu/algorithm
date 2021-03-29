function solution(n, edge) {
    const visited = Array(n + 1).fill(false);
    const distance = Array(n + 1);
    const edges = Array.from(Array(n + 1), () => []);
    edge.forEach((e) => {
        const [a, b] = e;
        edges[a].push(b);
        edges[b].push(a);
    });
    distance[1] = 0;
    const q = [1];
    visited[1] = true;
    let count = 0;
    while (q.length > 0) {
        const qsize = q.length;
        count++;
        for (let i = 0; i < qsize; ++i) {
            const current = q.shift();
            for (let j = 0; j < edges[current].length; ++j) {
                const next = edges[current][j];
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = count;
                    q.push(next);
                }
            }
        }
    }
    let maxDintanceNodes = [];
    let maxDistance = 0;
    for (let i = 1; i < distance.length; ++i) {
        if (distance[i] > maxDistance) {
            maxDistance = distance[i];
            maxDintanceNodes = [i];
        } else if (distance[i] === maxDistance) {
            maxDintanceNodes.push(i);
        }
    }
    return maxDintanceNodes.length;
}

console.log(
    solution(6, [
        [3, 6],
        [4, 3],
        [3, 2],
        [1, 3],
        [1, 2],
        [2, 4],
        [5, 2],
    ])
);
