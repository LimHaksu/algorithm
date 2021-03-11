def solution(maps):
    return bfs(maps)

from collections import deque
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

def bfs(maps):
    current = [0,0]
    q = deque()
    q.append(current)
    visited = [[False for j in range(len(maps[0]))] for i in range(len(maps))]
    visited[0][0] = True
    count = 0
    while len(q) > 0:
        qsize = len(q)
        count += 1
        for i in range(qsize):
            current = q.popleft()
            r, c = current[0], current[1]
            if r == len(maps)-1 and c == len(maps[0])-1:
                return count
            for j in range(4):
                nr = r + dr[j]
                nc = c + dc[j]
                if boundary_check(nr,nc,maps) and maps[nr][nc] == 1 and visited[nr][nc] == False:
                    visited[nr][nc] = True
                    q.append([nr,nc])
    return -1        

def boundary_check(r, c, maps):
    return r >= 0 and r < len(maps) and c >= 0 and c < len(maps[0])


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]))