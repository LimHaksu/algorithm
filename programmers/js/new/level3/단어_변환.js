let min = Number.MAX_SAFE_INTEGER;
function solution(begin, target, words) {
    var answer = 0;
    const visited = Array(words.length).fill(false);
    dfs(begin, target, visited, words, 0);
    return min === Number.MAX_SAFE_INTEGER ? 0 : min;
}

function dfs(current, target, visited, words, count) {
    if (current === target) {
        if (count < min) {
            min = count;
        }
        return;
    }
    for (let i = 0; i < words.length; ++i) {
        const dist = getDistance(current, words[i]);
        if (dist === 1 && !visited[i]) {
            visited[i] = true;
            dfs(words[i], target, visited, words, count + 1);
            visited[i] = false;
        }
    }
}

function getDistance(w1, w2) {
    let count = 0;
    for (let i = 0; i < w1.length; ++i) {
        if (w1[i] !== w2[i]) {
            count++;
        }
    }
    return count;
}

console.log(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]));
