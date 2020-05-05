function solution(n) {
    let dp = Array.from(Array(n));
    dp[0] = 1;
    if (n > 1) {
        dp[1] = 2;
    }
    for (let i = 2; i < n; ++i) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
    }
    return dp[n - 1];
}

console.log(solution(4));