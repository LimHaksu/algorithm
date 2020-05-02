function solution(board, moves) {
    var answer = 0;
    let stack = [];
    moves.forEach(e => {
        const item = get(e - 1, board);
        if (item != -1) {
            if (stack.length > 0) {
                if (stack[stack.length - 1] != item) {
                    stack.push(item);
                } else {
                    stack.pop();
                    answer += 2;
                }
            } else {
                stack.push(item);
            }
        }
    })
    return answer;
}
function get(i, board) {
    let r = 0;
    const height = board.length;
    while (r < height) {
        if (board[r][i] > 0) {
            const ret = board[r][i];
            board[r][i] = 0;
            return ret;
        }
        r++;
    }
    return -1;
}

console.log(solution([[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]));