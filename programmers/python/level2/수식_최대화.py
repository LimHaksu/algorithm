from itertools import permutations
import re
from collections import deque
def solution(expression):
    answer = 0
    numbers = list(map(int, re.compile('[-*+]').split(expression)))
    ops = list(filter(lambda e: e!='',re.compile('\d').split(expression)))
    
    for permu in permutations(['*', '+', '-']):
        cns = numbers.copy()
        cos = ops.copy()
        for op in permu:
            new_cos = []
            stack = deque()
            stack.append(cns[0])
            for i in range(len(cos)):
                co = cos[i]
                if co == op:
                    stack.append(calc(stack.pop(), cns[i+1], op))
                else:
                    stack.append(cns[i+1])
                    new_cos.append(co)
            cns = stack
            cos = new_cos
        tans = abs(cns[0])
        if tans > answer:
            answer = tans   

    return answer

def calc(n1, n2, op):
    ops = {
        '+' : n1 + n2,
        '-' : n1 - n2,
        '*' : n1 * n2,
    }
    return ops[op]

print(solution("100-200*300-500+20"))