def solution(n, money):
    dp = [0 for i in range(n+1)]
    dp[0] = 1
    for m in money:
        for i in range(1, n+1):
            if m <= i:
                dp[i] += dp[i - m]
    return dp[n]

print(solution(5, [1,2,5]))