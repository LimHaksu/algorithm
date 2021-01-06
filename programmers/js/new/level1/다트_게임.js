function solution(dartResult) {
    const scores = [0, 0, 0];
    let scoreIdx = -1;
    let num = 0;
    for (let i = 0; i < dartResult.length; ++i) {
        const c = dartResult.charAt(i);
        if (c === "1") {
            scoreIdx++;
            if (dartResult.charAt(i + 1) === "0") {
                num = 10;
                i++;
            } else {
                num = 1;
            }
            scores[scoreIdx] = num;
        } else if ((c >= "2" && c <= "9") || c === "0") {
            scoreIdx++;
            num = parseInt(c);
            scores[scoreIdx] = num;
        } else if (c === "D") {
            scores[scoreIdx] *= scores[scoreIdx];
        } else if (c === "T") {
            scores[scoreIdx] *= scores[scoreIdx] * scores[scoreIdx];
        } else if (c === "*") {
            if (scoreIdx >= 1) {
                scores[scoreIdx - 1] *= 2;
            }
            scores[scoreIdx] *= 2;
        } else if (c === "#") {
            scores[scoreIdx] *= -1;
        }
    }
    return scores.reduce((acc, cv) => acc + cv, 0);
}
