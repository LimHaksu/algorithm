def solution(m, n, board):
    board = [[c for c in row] for row in board]
    answer = 0
    while True:
        result = check_remove(board)
        count, remove_check = result[0], result[1]
        if count == 0:
            break
        answer += count
        down(board, remove_check)
    return answer

def check_remove(board):
    remove_check = [[False for j in range(len(board[0]))] for i in range(len(board))]
    count = 0
    for i in range(len(board)-1):
        for j in range(len(board[0])-1):
            if board[i][j] != 0 and board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1]:
                remove_check[i][j] = remove_check[i][j+1] = remove_check[i+1][j] = remove_check[i+1][j+1] = True

    for i in range(len(remove_check)):
        for j in range(len(remove_check[0])):
            if remove_check[i][j]:
                count += 1
    return [count, remove_check]

def down(board, remove_check):
    for j in range(len(board[0])):
        temp = []
        for i in range(len(board)):
            if remove_check[i][j] == False:
                temp.append(board[i][j])
        for i in range(len(board)-len(temp)):
            board[i][j] = 0
        for i in range(len(board)-1, len(board)-1-len(temp), -1):
            board[i][j] = temp.pop()

print(solution(4,	5	,["CCBDE", "AAADE", "AAABF", "CCBBF"]))