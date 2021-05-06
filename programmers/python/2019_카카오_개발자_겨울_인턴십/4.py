import sys
sys.setrecursionlimit(10**6)
def solution(k, room_number):
    answer = []
    p = {}
    for num in room_number:
        p_num = find(p, num)
        answer.append(p_num)
        union(p, p_num, p_num+1)
    return answer

def find(p, a):
    if a in p:
        pa = p[a]
    else:
        return a
    p[a] = find(p, pa)
    return p[a]

def union(p, a, b):
    pa = find(p, a)
    pb = find(p, b)
    if pa > pb:
        p[b] = pa
    elif pb > pa:
        p[a] = pb

# print(solution(pow(10,12), [i for i in range(pow(10,12)-200000, pow(10,12))]))
print(solution(	10, [6,5,4,3,2,1,1]))