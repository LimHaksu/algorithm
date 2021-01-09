function solution(s) {
    var answer = "";
    let max = Number.MIN_SAFE_INTEGER;
    let min = Number.MAX_SAFE_INTEGER;
    s.split(" ").forEach((num) => {
        max = Math.max(max, num);
        min = Math.min(min, num);
    });
    return min + " " + max;
}
