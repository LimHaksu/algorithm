def solution(n,a,b):
    answer = 1
    if a > b:
        a, b = b, a
    while True:
        if b - a == 1 and a % 2 == 1:
            return answer
        b = (b+1) // 2
        a = (a+1) // 2
        answer += 1
        

print(solution(	8, 4, 7))