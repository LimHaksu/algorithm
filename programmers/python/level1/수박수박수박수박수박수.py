def solution(n):
    # return ''.join(['수' if i % 2 == 0 else '박' for i in range(n)])
    return ('수박'*n)[:n]

print(solution(3))
print(solution(4))