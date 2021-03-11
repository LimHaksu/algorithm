from itertools import combinations
def solution(numbers, target):
    answer = 0
    for i in range(1, len(numbers)+1):
        for combi in combinations(range(len(numbers)), i):
            sum = 0
            for j in range(len(numbers)):
                if j in combi:
                    sum += numbers[j]
                else:
                    sum -= numbers[j]
            if sum == target:
                answer += 1
    return answer

print(solution([1,1,1,1,1],3))