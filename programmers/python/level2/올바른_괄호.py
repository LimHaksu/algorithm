def solution(s):
    top = -1
    for c in s:
        if c == '(':
            top += 1
        else:
            if top < 0:
                return False
            else:
                top -= 1
    return top == -1