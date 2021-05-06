# import sys
# sys.setrecursionlimit(10**6)
# def solution(k, room_number):
#     answer = []
#     p = {}
#     for num in room_number:
#         p_num = find(p, num)
#         answer.append(p_num)
#         union(p, p_num, p_num+1)
#     return answer

# def find(p, a):
#     if a in p:
#         pa = p[a]
#     else:
#         return a
#     p[a] = find(p, pa)
#     return p[a]

# def union(p, a, b):
#     pa = find(p, a)
#     pb = find(p, b)
#     if pa > pb:
#         p[b] = pa
#     elif pb > pa:
#         p[a] = pb

def solution(k, room_number):
    room_dic = {}
    ret = []
    for n in room_number:
        visit = [n]
        while n in room_dic:
            n = room_dic[n]
            visit.append(n)
        ret.append(n)
        for j in visit:
            room_dic[j] = n+1
    return ret

solution(pow(10,12), [1 for i in range(200000)])
# print(solution(	10, [6,5,4,3,2,1,1]))