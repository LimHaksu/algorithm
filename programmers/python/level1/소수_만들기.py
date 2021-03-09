answer = 0
is_prime = [False for i in range(3001)]
def solution(nums):
    checked = [False for i in range(3001)]
    for i in range(2,3001):
        if checked[i] == False:
            is_prime[i] = True
            for j in range(i, 3001, i):
                checked[j] = True
    visited = [False for i in range(len(nums))]
    dfs(0, visited, 0, nums)
    return answer

def dfs(count, visited, idx, nums):
    if count == 3:
        s = 0
        for i in range(len(nums)):
            if visited[i] == True:
                s += nums[i]
        if is_prime[s]:
            global answer
            answer += 1
        return
    if idx == len(nums):
        return
    visited[idx] = True
    dfs(count+1, visited, idx+1, nums)
    visited[idx] = False
    dfs(count, visited, idx+1, nums)

solution([1,2,3,4])