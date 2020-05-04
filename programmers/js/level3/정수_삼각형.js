function solution(triangle) {
    var answer = 0;
    let dp = Array.from(Array(triangle.length), () => Array(triangle.length));
    dp[0][0] = triangle[0][0];
    for (let i = 1; i < triangle.length; ++i) {
        for (let j = 0; j < i + 1; ++j) {
            if (j == 0) {
                dp[i][j] = (dp[i - 1][j] + triangle[i][j]);
            } else if (j == i) {
                dp[i][j] = (dp[i - 1][j - 1] + triangle[i][j]);
            } else {
                dp[i][j] = (Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]);
            }
        }
    }
    for (let j = 0; j < dp.length; ++j) {
        if (dp[dp.length - 1][j] > answer) {
            answer = dp[dp.length - 1][j];
        }
    }
    return answer;
}

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));