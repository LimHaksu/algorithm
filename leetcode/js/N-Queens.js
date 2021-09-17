/**
 * @param {number} n
 * @return {string[][]}
 */
const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
const dc = [0, 1, 1, 1, 0, -1, -1, -1];

var solveNQueens = function (n) {
    const answer = [];
    const arr = Array.from(Array(n), () => Array(n).fill(false));
    dfs(arr, 0, 0, answer);
    return answer;
};

function dfs(arr, r, count, answer) {
    if (count === arr.length) {
        const temp = [];
        for (let i = 0; i < arr.length; ++i) {
            const row = [];
            for (let j = 0; j < arr[0].length; ++j) {
                row.push(arr[i][j] ? "Q" : ".");
            }
            temp.push(row.join(""));
        }
        answer.push(temp);
        return;
    }
    for (let c = 0; c < arr[0].length; ++c) {
        if (check(arr, r, c)) {
            arr[r][c] = true;
            dfs(arr, r + 1, count + 1, answer);
            arr[r][c] = false;
        }
    }
}

function check(arr, r, c) {
    for (let d = 0; d < dr.length; ++d) {
        let nr = r + dr[d];
        let nc = c + dc[d];
        while (bdCheck(arr, nr, nc)) {
            if (arr[nr][nc]) {
                return false;
            }
            nr += dr[d];
            nc += dc[d];
        }
    }
    return true;
}

function bdCheck(arr, r, c) {
    return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
}

console.log(solveNQueens(1));
