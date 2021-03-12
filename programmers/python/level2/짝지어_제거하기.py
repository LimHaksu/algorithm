from collections import deque
def solution(s):
    stack = deque()
    for c in s:
        if len(stack) == 0:
            stack.append(c)
        else:
            if stack[-1] == c:
                stack.pop()
            else:
                stack.append(c)
    return 1 if len(stack) == 0 else 0