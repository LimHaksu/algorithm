def solution(n):
    return get10Num(get3Num(n))

def get3Num(n):
    res = ''
    while n > 0:
        res += str(n % 3)
        n = n//3
    return res

def get10Num(n):
    n = reversed(n)
    current = 1
    res = 0
    for c in n:
        print(c)
        res += current * int(c)
        current *= 10
    return res

solution(30)