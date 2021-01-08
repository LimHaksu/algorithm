let answer = 0;
function solution(numbers, target) {
    dfs(numbers, 0, Array(numbers.length).fill(false), target);
    return answer;
}

function dfs(numbers, idx, checked, target) {
    if (idx === numbers.length) {
        let sum = numbers.reduce((acc, num, i) => {
            return acc + (checked[i] ? num : -num);
        }, 0);
        if (sum === target) answer++;
        return;
    }
    checked[idx] = true;
    dfs(numbers, idx + 1, checked, target);
    checked[idx] = false;
    dfs(numbers, idx + 1, checked, target);
}

console.log(solution([1, 1, 1, 1, 1], 3));
