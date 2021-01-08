function solution(board) {
    const arr = Array.from(Array(board.length), () => Array(board[0].length).fill(0));
    for (let j = 0; j < board[0].length; ++j) {
        arr[0][j] = board[0][j];
    }
    for (let i = 0; i < board.length; ++i) {
        arr[i][0] = board[i][0];
    }
    let max = arr[0][0] === 0 ? 0 : 1;
    for (let i = 1; i < board.length; ++i) {
        for (let j = 1; j < board[0].length; ++j) {
            if (board[i][j] === 1) {
                arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j], arr[i - 1][j - 1]) + 1;
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
    }

    return max * max;
}

console.log(
    solution([
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0],
    ])
);

console.log(
    solution([
        [0, 0, 1, 1],
        [1, 1, 1, 1],
    ])
);
