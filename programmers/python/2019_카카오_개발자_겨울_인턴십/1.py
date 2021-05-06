def solution(board, moves):
    answer = 0
    stack = []
    for m in moves:
        col = m - 1
        doll = get_doll(board, col)
        if doll:
            if len(stack) > 0 and stack[-1] == doll:
                stack.pop()
                answer += 2
            else:
                stack.append(doll)
    return answer

def get_doll(board, col):
    row = 0
    n = len(board)
    while row < n:
        if board[row][col] != 0:
            result = board[row][col]
            board[row][col] = 0
            return result
        row += 1
    return None

print(solution(	[[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]))