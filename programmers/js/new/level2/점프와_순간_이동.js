function solution(n) {
    var ans = 0;
    while (n > 0) {
        if (n % 2 === 1) {
            ans++;
            n--;
        } else {
            n /= 2;
        }
    }
    return ans;
}
