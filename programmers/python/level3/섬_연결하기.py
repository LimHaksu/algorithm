from heapq import heappush, heappop
def solution(n, costs):
    answer = 0
    adj_list = [[] for i in range(n)]
    for f, t, c in costs:
        adj_list[f].append((t, c))
        adj_list[t].append((f, c))
    current = 0
    count = 1
    p = [i for i in range(n)]
    hq = []
    while count < n:
        for next_number, cost in adj_list[current]:
            if is_same_parent(p, 0, next_number) == False:
                heappush(hq, (cost, next_number))
        cost, number = heappop(hq)
        if is_same_parent(p, 0, number) == False:
            current = number
            answer += cost
            count += 1
            union(p, 0, number)
    return answer

def is_same_parent(p, a, b):
    pa = find(p, a)
    pb = find(p, b)
    return pa == pb

def union(p, a, b):
    pa = find(p, a)
    pb = find(p, b)
    if pa < pb:
        p[b] = pa
        return True
    elif pb < pa:
        p[a] = pb
        return True
    return False

def find(p, a):
    pa = p[a]
    if pa == a:
        return a
    p[a] = find(p, pa)
    return p[a]

print(solution(	4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]))