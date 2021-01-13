var answer = Number.MAX_SAFE_INTEGER;
function solution(N, number) {
    dfs(0, 0, N, number);
    if (answer === Number.MAX_SAFE_INTEGER) {
        answer = -1;
    }
    return answer;
}

function dfs(count, result, N, number) {
    if (count > 8) return;
    // NN
    let NN = "";
    for (let i = 1; i < 9 - count; ++i) {
        NN += N;
        const num = parseInt(NN);
        // N+N
        let res = result + num;
        if (res === number && count + i < answer) {
            answer = count + i;
        }
        dfs(count + i, res, N, number);
        // N-N
        if (result !== num) {
            res = result - num;
            if (res === number && count + i < answer) {
                answer = count + i;
            }
            dfs(count + i, res, N, number);
            res = num - result;
            if (res === number && count + i < answer) {
                answer = count + i;
            }
            dfs(count + i, res, N, number);
            // N*N
            res = result * num;
            if (res === number && count + i < answer) {
                answer = count + i;
            }
            dfs(count + i, res, N, number);
        }
        // N/N
        if (num !== 0) {
            res = parseInt(result / num);
            if (res === number && count + i < answer) {
                answer = count + i;
            }
            dfs(count + i, res, N, number);
        }
        if (result !== 0) {
            res = parseInt(num / result);
            if (res === number && count + i < answer) {
                answer = count + i;
            }
            dfs(count + i, res, N, number);
        }
    }
}

console.log(solution(5, 12));
