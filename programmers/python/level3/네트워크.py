def solution(n, computers):
    answer = 0
    p = [i for i in range(n)]
    for i in range(n):
        for j in range(i):
            if computers[i][j] == 1:
                union(p, i, j)
    ans_set = set()
    for i in range(n):
        ans_set.add(find(p,i))
    return len(ans_set)

def find(p, a):
    pa = p[a]
    if pa == a:
        return a
    p[a] = find(p, pa)
    return p[a]

def union(p, a, b):
    pa = find(p, a)
    pb = find(p, b)
    if pa < pb:
        p[pb] = pa
    elif pb < pa:
        p[pa] = pb