function solution(nums) {
    const set = new Set();
    nums.forEach((n) => {
        set.add(n);
    });
    return Math.min(nums.length / 2, set.size);
}

console.log(solution([3, 1, 2, 3]));
