from collections import deque
def solution(s):
    dq = deque(s)
    answer = 0
    for i in range(len(dq)):
        dq.rotate()
        if is_valid(''.join(dq)):
            answer += 1
    
    return answer

def is_valid(s):
    stack = []
    for c in s:
        if c in ['[', '{', '(']:
            stack.append(c)
        else:
            if len(stack) == 0:
                return False
            if stack[len(stack)-1] == '[':
                if c == ']' and len(stack) > 0:
                    stack.pop()
                else:
                    return False
            elif stack[len(stack)-1] == '{':
                if c == '}' and len(stack) > 0:
                    stack.pop()
                else:
                    return False
            elif stack[len(stack)-1] == '(':
                if c == ')' and len(stack) > 0:
                    stack.pop()
                else:
                    return False
    return len(stack) == 0