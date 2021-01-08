function solution(arr) {
    const check = Array.from(Array(arr.length), () => Array(arr.length).fill(false));
    dfs(arr, 0, arr.length, 0, arr.length, check);
    const count = [0, 0];
    check.forEach((row, i) => {
        row.forEach((c, j) => {
            if (c) {
                count[arr[i][j]]++;
            }
        });
    });
    return count;
}

function dfs(arr, t, b, l, r, check) {
    if (isAllEqual(arr, t, b, l, r)) {
        checkRemainFalse(check, t, b, l, r);
        return;
    }
    const rm = parseInt((t + b) / 2);
    const cm = parseInt((l + r) / 2);
    // 1
    if (isAllEqual(arr, t, rm, l, cm)) {
        checkRemainFalse(check, t, rm, l, cm);
    } else {
        dfs(arr, t, rm, l, cm, check);
    }
    // 2
    if (isAllEqual(arr, t, rm, cm, r)) {
        checkRemainFalse(check, t, rm, cm, r);
    } else {
        dfs(arr, t, rm, cm, r, check);
    }
    // 3
    if (isAllEqual(arr, rm, b, l, cm)) {
        checkRemainFalse(check, rm, b, l, cm);
    } else {
        dfs(arr, rm, b, l, cm, check);
    }
    // 4
    if (isAllEqual(arr, rm, b, cm, r)) {
        checkRemainFalse(check, rm, b, cm, r);
    } else {
        dfs(arr, rm, b, cm, r, check);
    }
}

function isAllEqual(arr, t, b, l, r) {
    const val = arr[t][l];
    for (let i = t; i < b; ++i) {
        for (let j = l; j < r; ++j) {
            if (arr[i][j] !== val) {
                return false;
            }
        }
    }
    return true;
}

function checkRemainFalse(check, t, b, l, r) {
    for (let i = t; i < b; ++i) {
        for (let j = l; j < r; ++j) {
            check[i][j] = false;
        }
    }
    check[t][l] = true;
}

console.log(
    solution([
        [1, 1, 0, 0],
        [1, 0, 0, 0],
        [1, 0, 0, 1],
        [1, 1, 1, 1],
    ])
);
