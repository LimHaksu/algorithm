function solution(brown, yellow) {
    for (let m = 3; m <= 2000; ++m) {
        for (let n = m; n <= 2000; ++n) {
            if ((m - 2) * (n - 2) === yellow && n * m === yellow + brown) {
                return [n, m];
            }
        }
    }
}
