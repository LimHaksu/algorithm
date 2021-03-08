def solution(n, m):
    return [gcd(n,m),lcm(n,m)]

def gcd(n, m):
    if n < m:
        n , m = m , n
    while m > 0:
        r = n % m
        n = m
        m = r
    return n

def lcm(n , m):
    return n*m/gcd(n, m)