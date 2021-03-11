def solution(board):
    answer = 0
    # 왼쪽, 위쪽, 대각선 위쪽 에서부터 연속된 1 개수
    count_list = [[0 for c in range(len(board[r]))] for r in range(len(board))]
    count_list[0][0] = 1 if board[0][0] == 1 else 0
    for c in range(1,len(board[0])):
        count_list[0][c] = board[0][c]
    for r in range(1,len(board)):
        count_list[r][0] = board[r][0]
    answer = 1 if count_list[0][0] else 0
    for r in range(1, len(board)):
        for c in range(1, len(board[r])):
            if board[r][c] == 1:
                count_list[r][c] = min(count_list[r][c-1], count_list[r-1][c], count_list[r-1][c-1]) + 1
                answer = max(answer, count_list[r][c] ** 2)
    return answer
