function solution(n, costs) {
    var answer = 0;
    const p = Array(n)
        .fill()
        .map((e, i) => i);
    costs.sort((a, b) => a[2] - b[2]);
    costs.forEach((e) => {
        const [a, b, cost] = e;
        const pa = find(a, p);
        const pb = find(b, p);
        if (pa !== pb) {
            union(a, b, p);
            answer += cost;
        }
    });
    return answer;
}

function union(a, b, p) {
    const pa = find(a, p);
    const pb = find(b, p);
    if (pa > pb) {
        p[pa] = pb;
    } else if (pb > pa) {
        p[pb] = pa;
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
    solution(4, [
        [0, 1, 1],
        [0, 2, 2],
        [1, 2, 5],
        [1, 3, 1],
        [2, 3, 8],
    ])
);
