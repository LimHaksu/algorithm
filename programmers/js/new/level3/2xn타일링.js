function solution(n) {
    const dp = Array(n + 1);
    dp[1] = 1;
    dp[2] = 2;
    for (let i = 3; i <= n; ++i) {
        dp[n] = dp[n - 1] + dp[n - 2];
    }
    return dp[n];
}
