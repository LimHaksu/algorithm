def solution(land):
    dp = [[0 for j in range(len(land[0]))] for i in range(len(land))]
    for j in range(len(land[0])):
        dp[0][j] = land[0][j]
    for i in range(1, len(land)):
        for j in range(len(land[i])):
            my_max = 0
            for k in range(len(land[i])):
                if j != k and dp[i-1][k] > my_max:
                    my_max = dp[i-1][k]
            dp[i][j] = land[i][j] + my_max
            
    return max(dp[len(dp)-1])

print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]	))