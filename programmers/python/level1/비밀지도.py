from pprint import pprint
def solution(n, arr1, arr2):
    answer = [[' ' for j in range(n)] for i in range(n)]
    for i, (num1, num2) in enumerate(zip(arr1, arr2)):
        for j in range(n-1, -1, -1):
            if num1 % 2 == 1 or num2 % 2 == 1:
                answer[i][j] = '#'
            num1 //= 2
            num2 //= 2
    answer = [''.join(i) for i in answer]
    return answer

pprint(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]))