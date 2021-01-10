let answer = 0;
function solution(nums) {
    const isPrime = Array(3000).fill(false);
    const checked = Array(3000).fill(false);
    for (let i = 2; i < 3000; ++i) {
        if (!checked[i]) {
            isPrime[i] = true;
            for (let j = i; j < 3000; j += i) {
                checked[j] = true;
            }
        }
    }
    const selected = Array(nums.length).fill(false);
    dfs(selected, 0, 0, nums, isPrime);
    return answer;
}

function dfs(selected, idx, count, nums, isPrime) {
    if (count === 3) {
        let sum = 0;
        for (let i = 0; i < selected.length; ++i) {
            if (selected[i]) {
                sum += nums[i];
            }
        }
        if (isPrime[sum]) {
            answer++;
        }
        return;
    }
    if (idx === selected.length) {
        return;
    }
    selected[idx] = true;
    dfs(selected, idx + 1, count + 1, nums, isPrime);
    selected[idx] = false;
    dfs(selected, idx + 1, count, nums, isPrime);
}

solution([1, 2, 3, 4]);
