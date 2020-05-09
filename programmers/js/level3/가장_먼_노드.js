function solution(n, edge) {
    const map = new Map();
    edge.forEach(row => {
        let f = row[0];
        let t = row[1];
        if (map.get(f) == undefined) {
            map.set(f, new Set());
        }
        if (map.get(t) == undefined) {
            map.set(t, new Set());
        }
        map.get(f).add(t);
        map.get(t).add(f);
    });

    const q = [];
    let current = 1;
    q.push(current);
    let answer = 0;
    let visited = Array(n + 1);
    for (let i = 1; i <= n; ++i) {
        visited[i] = false;
    }
    visited[1] = true;
    while (q.length > 0) {
        let size = q.length;
        answer = size;
        for (let i = 0; i < size; ++i) {
            current = q.shift();
            const s = map.get(current);
            s.forEach(t => {
                if (!visited[t]) {
                    visited[t] = true;
                    q.push(t);
                }
            })
        }
    }
    return answer;
}

console.log(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]));