function solution(m, n, board) {
    var answer = 0;
    board = board.map((row) => {
        return row.split("");
    });
    let find = false;
    do {
        find = false;
        const check = Array.from(Array(m), () => Array(n).fill(false));
        for (let i = 0; i < m - 1; ++i) {
            for (let j = 0; j < n - 1; ++j) {
                if (isEqualInSquare(i, j, board)) {
                    find = true;
                    markTrue(i, j, check);
                }
            }
        }
        for (let i = 0; i < m; ++i) {
            for (let j = 0; j < n; ++j) {
                if (check[i][j]) {
                    answer++;
                    board[i][j] = 0;
                }
            }
        }
        for (let j = 0; j < n; ++j) {
            const arr = [];
            for (let i = 0; i < m; ++i) {
                if (board[i][j] !== 0) {
                    arr.push(board[i][j]);
                }
            }
            const size = arr.length;
            for (let i = 0; i < m - size; ++i) {
                board[i][j] = 0;
            }
            for (let i = m - size; i < m; ++i) {
                board[i][j] = arr[i - (m - size)];
            }
        }
    } while (find);
    return answer;
}

function markTrue(i, j, check) {
    for (let s = i; s < i + 2; ++s) {
        for (let t = j; t < j + 2; ++t) {
            check[s][t] = true;
        }
    }
}

function isEqualInSquare(i, j, board) {
    for (let s = i; s < i + 2; ++s) {
        for (let t = j; t < j + 2; ++t) {
            if (board[s][t] !== board[i][j] || board[i][j] === 0) {
                return false;
            }
        }
    }
    return true;
}

console.log(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]));
