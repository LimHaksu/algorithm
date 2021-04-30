from collections import deque
def solution(n, edge):
    adj_list = [[] for i in range(n+1)]
    for f, t in edge:
        adj_list[f].append(t)
        adj_list[t].append(f)
    visited = [False for i in range(n+1)]
    visited[1] = True
    q = deque([1])
    while len(q) > 0:
        qsize = len(q)
        for i in range(qsize):
            num = q.popleft()
            for next in adj_list[num]:
                if visited[next] == False:
                    visited[next] = True
                    q.append(next)
    return qsize


print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))