max = 20_000_000
def solution(n, s, a, b, fares):
    arr = [[0 if i == j else max for j in range(n+1)] for i in range(n+1)]
    for fare in fares:
        f = fare[0]
        t = fare[1]
        c = fare[2]
        arr[f][t] = c
        arr[t][f] = c
    
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                if arr[i][k] + arr[k][j] < arr[i][j]:
                    arr[i][j] = arr[i][k] + arr[k][j]
    
    answer = max
    for num in range(1,n+1): # 합승 지점
        cost = arr[s][num] + arr[num][a] + arr[num][b]
        if cost < answer:
            answer = cost
    return answer

print(solution(	7, 3, 4, 1, [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]))