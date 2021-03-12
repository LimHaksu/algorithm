def solution(N, road, K):
    inf = 987654321
    cost_map = [[inf for j in range(N+1)] for i in range(N+1)]
    cost_map[1][1] = 0
    for i in range(len(road)):
        a, b, c = road[i][0], road[i][1], road[i][2]
        if c < cost_map[a][b]:
            cost_map[a][b] = cost_map[b][a] = c

    answer = 0
    for k in range(1, N+1):
        for f in range(1, N+1):
            for t in range(1, N+1):
                if cost_map[f][k] + cost_map[k][t] < cost_map[f][t]:
                    cost_map[f][t] = cost_map[f][k] + cost_map[k][t]
    for t in range(1, N+1):
        if cost_map[1][t] <= K:
            answer += 1
    return answer

print(solution(	6, [[1, 2, 1], [1, 3, 2], [2, 3, 2], [3, 4, 3], [3, 5, 2], [3, 5, 3], [5, 6, 1]], 4))