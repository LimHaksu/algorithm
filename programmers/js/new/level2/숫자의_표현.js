function solution(n) {
    var answer = 0;
    let left = 1;
    let right = 2;
    let sum = 1;
    while (left < right) {
        if (sum === n) {
            answer++;
            sum -= left;
            left++;
        } else if (sum < n) {
            sum += right;
            right++;
        } else if (sum > n) {
            sum -= left;
            left++;
        }
    }
    return answer;
}

console.log(solution(15));
