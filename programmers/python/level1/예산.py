def solution(d, budget):
    answer = 0
    d.sort()
    for num in d:
        if budget >= num:
            answer += 1
            budget -= num
    return answer