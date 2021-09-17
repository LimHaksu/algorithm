/**
 * @param {number} n
 * @return {string[][]}
 */
const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
const dc = [0, 1, 1, 1, 0, -1, -1, -1];

var totalNQueens = function (n) {
    const arr = Array.from(Array(n), () => Array(n).fill(false));
    return dfs(arr, 0, 0, 0);
};

function dfs(arr, r, count, answer) {
    if (count === arr.length) {
        return answer + 1;
    }
    for (let c = 0; c < arr[0].length; ++c) {
        if (check(arr, r, c)) {
            arr[r][c] = true;
            answer = dfs(arr, r + 1, count + 1, answer);
            arr[r][c] = false;
        }
    }
    return answer;
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
