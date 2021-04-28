def solution(n):
    mod = 1000_000_007
    arr = [0 for i in range(n+1)]
    arr[1] = 1
    arr[2] = 2
    for i in range(3, n+1):
        arr[i] = (arr[i-1] + arr[i-2]) % mod
    return arr[n]