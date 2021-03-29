function solution(n, computers) {
    const p = Array(n)
        .fill(0)
        .map((e, i) => i);
    for (let i = 0; i < n; ++i) {
        for (let j = i + 1; j < n; ++j) {
            if (computers[i][j] === 1) {
                union(i, j, p);
            }
        }
    }
    const set = new Set();
    for (let i = 0; i < n; ++i) {
        set.add(find(i, p));
    }
    return set.size;
}

function union(a, b, p) {
    const pa = find(a, p);
    const pb = find(b, p);
    if (pa < pb) {
        p[pb] = pa;
    } else if (pa > pb) {
        p[pa] = pb;
    }
}

function find(a, p) {
    const pa = p[a];
    if (pa === a) {
        return a;
    }
    return (p[a] = find(pa, p));
}

console.log(
    solution(3, [
        [1, 1, 0],
        [1, 1, 1],
        [0, 1, 1],
    ])
);
