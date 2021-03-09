def solution(N, stages):
    stages.sort(reverse=True)
    count_dict = {}
    for num in stages:
        if num in count_dict:
            count_dict[num] += 1
        else:
            count_dict[num] = 1
    acc = count_dict[N+1] if N+1 in count_dict else 0
    failure = {}
    for key in range(N, 0, -1):
        if key in count_dict:
            acc += count_dict[key]
            failure[key] = count_dict[key] / acc
        else:
            failure[key] = 0
    return sorted(failure, key=lambda e: (failure[e], -e), reverse=True)

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4,4,4,4,4]))

