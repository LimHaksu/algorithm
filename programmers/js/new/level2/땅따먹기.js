function solution(land) {
    var answer = 0;
    const dp = Array.from(Array(land.length), () => Array(land[0].length));
    for (let j = 0; j < land[0].length; ++j) {
        dp[0][j] = land[0][j];
    }
    for (let i = 1; i < land.length; ++i) {
        for (let j = 0; j < land[i].length; ++j) {
            let max = 0;
            for (let k = 0; k < land[i].length; ++k) {
                if (j !== k && max < dp[i - 1][k]) {
                    max = dp[i - 1][k];
                }
            }
            dp[i][j] = max + arr[i][j];
        }
    }
    for (let j = 0; j < land[0].length; ++j) {
        if (answer < dp[land.length - 1][j]) {
            answer = dp[land.length - 1][j];
        }
    }
    return answer;
}
