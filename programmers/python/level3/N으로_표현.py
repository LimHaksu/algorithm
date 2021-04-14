answer = 9
ops = ['+', '-', '*', '/']
def solution(N, number):
    for op in ops:
        dfs(op, 0, number, N, 0)
    return -1 if answer == 9 else answer

def dfs(type, current, target, N, count):
    if current == target:
        global answer
        answer = min(answer, count)
        return
    if count > 8:
        return
    num_str = ''
    for i in range(1,9-count):
        num_str += str(N)
        num = int(num_str)
        if type == '+':
            next = current + num
        elif type == '-':
            next = current - num
        elif type == '*':
            next = current * num
        elif type == '/':
            next = current / num
        for op in ops:
            dfs(op, next, target, N, count+i)