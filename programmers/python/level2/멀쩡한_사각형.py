def solution(w,h):
    g = gcd(w,h)
    return w * h - (w+h-g)

def gcd(a,b):
    if a > b:
        a , b = b, a
    while b > 0:
        r = a % b
        a = b
        b = r
    return a

print(solution(8,12))