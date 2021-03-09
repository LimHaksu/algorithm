def solution(n):
    answer = 0
    visited = [False for i in range(n+1)]
    for num in range(2, n+1):
        if visited[num] == False:
            answer += 1
            for num2 in range(num, n+1, num):
                visited[num2] = True
    return answer