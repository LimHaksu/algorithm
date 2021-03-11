def solution(n):
    answer = 0
    left = 1
    right = 1
    my_sum = 1
    while left <= n:
        if my_sum == n:
            answer += 1
            right += 1
            my_sum += right
        elif my_sum > n:
            my_sum -= left
            left += 1
        elif my_sum < n:
            right += 1
            my_sum += right
    return answer

print(solution(15))