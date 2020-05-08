let p = [];
function solution(n, computers) {
    for (let i = 0; i < n; ++i) {
        p.push(i);
    }
    for (let i = 0; i < n; ++i) {
        for (let j = 0; j < n; ++j) {
            if (computers[i][j] == 1) {
                union(i, j);
            }
        }
    }
    const set = new Set();
    for (let i = 0; i < n; ++i) {
        set.add(find(i));
    }
    return set.size;
}

const union = (a, b) => {
    const pa = find(a);
    const pb = find(b);
    if (pa < pb) {
        p[pb] = pa;
    } else if (pb < pa) {
        p[pa] = pb;
    }
}

const find = (a) => {
    const pa = p[a];
    if (pa == a) {
        return a;
    }
    return p[a] = find(pa);
}

console.log(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]));