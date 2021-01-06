function solution(n) {
    const sqrt = parseInt(Math.sqrt(n));
    if (sqrt * sqrt === n) {
        return (sqrt + 1) * (sqrt + 1);
    }
    return -1;
}
