function solution(board, moves) {
    var answer = 0;
    const stack = [];
    moves.forEach((element) => {
        const doll = getNthDoll(board, element);
        if (doll === -1) {
            return;
        }
        if (stack.length === 0) {
            stack.push(doll);
        } else {
            if (stack[stack.length - 1] === doll) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(doll);
            }
        }
    });
    return answer;
}

function getNthDoll(board, n) {
    n--;
    let row = 0;
    const boardHeight = board.length;
    while (row < boardHeight) {
        if (board[row][n] > 0) {
            const ret = board[row][n];
            board[row][n] = 0;
            return ret;
        }
        row++;
    }
    return -1;
}
