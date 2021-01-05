function solution(s) {
    s = s.toLowerCase();
    const count = [0, 0];
    for (let i = 0; i < s.length; ++i) {
        const c = s.charAt(i);
        if (c === "p") {
            count[0]++;
        } else if (c === "y") {
            count[1]++;
        }
    }
    return count[0] === count[1];
}
