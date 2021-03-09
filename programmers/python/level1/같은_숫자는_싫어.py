def solution(arr):
    answer = []
    last = -1
    for num in arr:
        if num != last:
            last = num
            answer.append(num)
    return answer