from itertools import permutations
def solution(numbers):
    length = 10 ** len(numbers)
    is_prime = [False for i in range(length)]
    visited = [False for i in range(length)]
    for i in range(2, length):
        if visited[i] == False:
            is_prime[i] = True
            for j in range(i, length, i):
                visited[j] = True

    answer = 0
    my_set = set()
    for l in range(1,len(numbers)+1):
        for permu in permutations(numbers,l):
            num = int(''.join(permu))
            if is_prime[num]:
                my_set.add(num)

    return len(my_set)
print(solution("011"))