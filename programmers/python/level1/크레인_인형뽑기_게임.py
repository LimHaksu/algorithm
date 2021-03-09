from collections import deque
def solution(board, moves):
    answer = 0
    stack = deque([])
    for num in moves:
        doll = get_doll(board, num)
        if doll > 0:
            if len(stack) > 0 and stack[-1] == doll:
                stack.pop()
                answer += 2
            else:
                stack.append(doll)
    return answer

def get_doll(board, index):
    index -= 1
    for i in range(len(board)):
        if board[i][index] > 0:
            doll = board[i][index]
            board[i][index] = 0
            return doll
    return -1

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]))