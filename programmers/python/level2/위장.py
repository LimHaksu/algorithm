from itertools import combinations
def solution(clothes):
    dic = dict()
    for cloth in clothes:
        kind = cloth[1]
        if kind in dic:
            dic[kind] += 1
        else:
            dic[kind] = 2
    
    answer = 1
    for key in dic:
        answer *= dic[key]
    return answer - 1

print(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]))