def solution(n):
    arr = [[0 for j in range(n)] for i in range(n)]
    d = 0 # 0 : 아래, 1: 오른쪽, 2: 왼쪽 대각선 위
    count = 1
    for i in range(n):
        arr[i][0] = count
        count += 1
    i, j = n-1, 0
    for length in range(n-1, 0, -1):
        d = rotate(d)
        for _ in range(length):
            i,j = get_next_ij(d,i,j)
            arr[i][j] = count
            count += 1
    answer = []
    for i in range(n):
        for j in range(i+1):
            answer.append(arr[i][j])
    return answer

def get_next_ij(d, i, j):
    if d == 0:
        return (i+1, j)
    elif d == 1:
        return (i, j+1)
    else:
        return (i-1, j-1)

def rotate(d):
    d += 1
    if d == 3:
        d = 0
    return d

print(solution(4))