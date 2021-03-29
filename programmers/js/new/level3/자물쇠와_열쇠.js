function solution(key, lock) {
    var answer = false;
    const M = key.length;
    const N = lock.length;
    const size = N + 2 * M - 2;
    const pan = Array.from(Array(size), () => Array(size).fill(0));
    for (let i = M - 1; i < M - 1 + N; ++i) {
        for (let j = M - 1; j < M - 1 + N; ++j) {
            pan[i][j] = lock[i - (M - 1)][j - (M - 1)];
        }
    }
    f: for (let t = 0; t < 4; ++t) {
        for (let sr = 0; sr < N + M - 1; ++sr) {
            for (let sc = 0; sc < N + M - 1; ++sc) {
                const cpPan = copyPan(pan);
                tryKey(key, cpPan, sr, sc);
                if (checkPan(cpPan, M, N)) {
                    answer = true;
                    break f;
                }
            }
        }
        key = rotate(key);
    }
    return answer;
}

function rotate(key) {
    const result = Array.from(Array(key.length), () => Array(key.length));
    for (let i = 0; i < key.length; ++i) {
        for (let j = 0; j < key.length; ++j) {
            result[i][j] = key[key.length - 1 - j][i];
        }
    }
    return result;
}

function copyPan(pan) {
    return pan.map((row) => [...row]);
}

function tryKey(key, pan, sr, sc) {
    for (let i = 0; i < key.length; ++i) {
        for (let j = 0; j < key.length; ++j) {
            if (key[i][j] === 1) {
                if (pan[sr + i][sc + j] === 0) {
                    pan[sr + i][sc + j] = 1;
                } else {
                    pan[sr + i][sc + j] = 0;
                }
            }
        }
    }
}

function checkPan(pan, M, N) {
    for (let i = M - 1; i < M - 1 + N; ++i) {
        for (let j = M - 1; j < M - 1 + N; ++j) {
            if (pan[i][j] === 0) {
                return false;
            }
        }
    }
    return true;
}

console.log(
    solution(
        [
            [0, 0, 0],
            [1, 0, 0],
            [0, 1, 1],
        ],
        [
            [1, 1, 1],
            [1, 1, 0],
            [1, 0, 1],
        ]
    )
);
