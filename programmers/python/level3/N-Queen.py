def solution(n):
    arr = []
    s = set()
    return dfs(0, 0, arr, n, 0, s)

def dfs(count, r, arr, n, answer, s):
    if count == n:
        answer += 1
        return answer
    for c in range(n):
        if is_valid(r,c,arr, s):
            arr.append([r,c])
            s.add(c)
            answer = dfs(count+1, r+1, arr, n, answer, s)
            s.remove(c)
            arr.pop()
    return answer

def is_valid(cr,cc,arr,s):
    if cc in s:
        return False
    for r, c in arr:
        if abs(r-cr) == abs(c-cc):
            return False
    return True