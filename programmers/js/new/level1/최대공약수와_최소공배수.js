function solution(n, m) {
    const gcd = getGcd(n, m);
    const lcm = parseInt((n * m) / gcd);
    return [gcd, lcm];
}

function getGcd(a, b) {
    if (a < b) {
        let c = a;
        a = b;
        b = c;
    }
    while (b !== 0) {
        let c = a % b;
        a = b;
        b = c;
    }
    return a;
}
