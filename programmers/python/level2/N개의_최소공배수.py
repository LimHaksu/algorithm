def solution(arr):
    answer = arr[0]
    for i in range(1, len(arr)):
        answer = lcm(answer, arr[i])
    return answer

def gcd(a,b):
    if a > b:
        a , b = b , a
    while b > 0:
        t = a % b
        a = b
        b = t
    return a

def lcm(a,b):
    return a * b / gcd(a,b)