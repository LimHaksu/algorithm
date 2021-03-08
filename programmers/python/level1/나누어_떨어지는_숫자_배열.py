def solution(arr, divisor):
    answer = list(filter(lambda x: x%divisor==0, arr))
    if len(answer) == 0:
        answer.append(-1)
    return sorted(answer)