const di = [-1, 0, 1, 0];
const dj = [0, 1, 0, -1];
function solution(board) {
    const visited = Array.from(Array(board.length), () => Array(board.length).fill(false));
    const minArr = Array.from(Array(board.length), () => Array(board.length).fill(Number.MAX_VALUE));
    visited[0][0] = true;
    dfs(0, 0, 1, 0, board, visited, minArr);
    dfs(0, 0, 2, 0, board, visited, minArr);
    console.log(minArr);
    return minArr[board.length - 1][board.length - 1];
}

function dfs(ci, cj, cd, cost, board, visited, minArr) {
    const N = board.length;
    if (cost > minArr[ci][cj]) {
        return;
    }
    minArr[ci][cj] = cost;
    if (ci === N - 1 && cj === N - 1) {
        return;
    }

    let ld = cd - 1;
    if (ld < 0) {
        ld += 4;
    }
    let ni = ci + di[ld];
    let nj = cj + dj[ld];
    if (bdCheck(ni, nj, board) && !visited[ni][nj]) {
        visited[ni][nj] = true;
        dfs(ni, nj, ld, cost + 600, board, visited, minArr);
        visited[ni][nj] = false;
    }

    let rd = cd + 1;
    if (rd > 3) {
        rd -= 4;
    }
    ni = ci + di[rd];
    nj = cj + dj[rd];
    if (bdCheck(ni, nj, board) && !visited[ni][nj]) {
        visited[ni][nj] = true;
        dfs(ni, nj, rd, cost + 600, board, visited, minArr);
        visited[ni][nj] = false;
    }
    ni = ci + di[cd];
    nj = cj + dj[cd];
    if (bdCheck(ni, nj, board) && !visited[ni][nj]) {
        visited[ni][nj] = true;
        dfs(ni, nj, cd, cost + 100, board, visited, minArr);
        visited[ni][nj] = false;
    }
}

function bdCheck(i, j, board) {
    return i >= 0 && i < board.length && j >= 0 && j < board.length && board[i][j] === 0;
}

console.log(
    solution([
        [2, 0, 1, 0, 1, 1, 0, 0, 0, 0],
        [2, 2, 2, 2, 1, 0, 1, 1, 0, 1],
        [1, 0, 0, 2, 0, 1, 1, 0, 1, 0],
        [0, 0, 0, 2, 0, 0, 1, 0, 0, 0],
        [0, 0, 0, 2, 1, 0, 1, 0, 1, 1],
        [0, 0, 1, 2, 1, 1, 0, 1, 0, 1],
        [0, 1, 2, 2, 1, 0, 0, 0, 1, 0],
        [1, 0, 2, 1, 2, 2, 2, 2, 2, 2],
        [0, 0, 2, 2, 2, 1, 0, 1, 0, 2],
        [1, 0, 0, 0, 0, 0, 0, 0, 1, 2],
    ])
);
