def solution(numbers):
    answer = set()
    for i, n in enumerate(numbers):
        for m in numbers[i+1:]:
            answer.add(n+m)
    return sorted(answer)