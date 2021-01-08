function solution(numbers) {
    var answer = 0;
    const visited = Array(10000000).fill(false);
    const isPrime = Array(10000000).fill(false);
    for (let i = 2; i <= 9999999; ++i) {
        if (!visited[i]) {
            isPrime[i] = true;
            for (let j = i; j <= 9999999; j += i) {
                visited[j] = true;
            }
        }
    }
    const set = new Set();
    const stack = [];
    const visited2 = Array(numbers.length).fill(false);
    answer = dfs(numbers, stack, visited2, 0, isPrime, set);
    return answer;
}

function dfs(numbers, stack, visited, answer, isPrime, set) {
    const num = parseInt(stack.join(""));
    if (stack.length > 0 && !set.has(num)) {
        set.add(num);
        if (isPrime[num]) {
            console.log(num);
            answer++;
        }
    }
    for (let i = 0; i < visited.length; ++i) {
        if (!visited[i]) {
            stack.push(numbers.charAt(i));
            visited[i] = true;
            answer = dfs(numbers, stack, visited, answer, isPrime, set);
            stack.pop();
            visited[i] = false;
        }
    }
    return answer;
}

console.log(solution("17"));
console.log(solution("011"));
