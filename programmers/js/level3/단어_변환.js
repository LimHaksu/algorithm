var answer = 987654321;
function solution(begin, target, words) {
    let visited = Array.from(Array(words.length), () => { false });
    dfs(0, begin, target, visited, words);
    if (answer == 987654321) answer = 0;
    return answer;
}

const dfs = (count, current, target, visited, words) => {
    if (count > answer) {
        return;
    }
    if (current == target) {
        if (count < answer) {
            answer = count;
        }
        return;
    }
    for (let i = 0; i < visited.length; ++i) {
        const d = countDiff(current, words[i]);
        if (d == 1 && !visited[i]) {
            visited[i] = true;
            dfs(count + 1, words[i], target, visited, words);
            visited[i] = false;
        }
    }
}
const countDiff = (current, word) => {
    let count = 0;
    for (let i = 0; i < word.length; ++i) {
        if (current[i] != word[i]) {
            count++;
        }
    }
    return count;
}

console.log(solution("hit", "cog", ["hot", "dot", 'dog', 'lot', 'log', 'cog']));