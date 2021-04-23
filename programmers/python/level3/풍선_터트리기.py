def solution(a):
    stack = []
    lcount = [0 for i in range(len(a))]
    rcount = [0 for i in range(len(a))]
    for i, num in enumerate(a):
        if len(stack) == 0:
            stack.append(num)
        else:
            while len(stack) > 0 and num < stack[len(stack)-1]:
                stack.pop()
            lcount[i] = len(stack)
            stack.append(num)
    stack = []
    for i in range(len(a)-1, -1, -1):
        num = a[i]
        if len(stack) == 0:
            stack.append(num)
        else:
            while len(stack) > 0 and num < stack[len(stack)-1]:
                stack.pop()
            rcount[i] = len(stack)
            stack.append(num)
    answer = 0
    for i in range(len(a)):
        if lcount[i] == 0 or rcount[i] == 0:
            answer += 1
    return answer