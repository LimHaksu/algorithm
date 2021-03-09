def solution(arr1, arr2):
    answer = [[0 for j in range(len(arr1[i]))] for i in range(len(arr1))]
    for i, a in enumerate(arr1):
        for j, v in enumerate(a):
            answer[i][j] = arr1[i][j] + arr2[i][j]
    return answer
