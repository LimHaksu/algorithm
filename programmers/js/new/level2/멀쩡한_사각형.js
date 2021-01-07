function solution(w, h) {
    const gcd = getGCD(w, h);
    let count = (w + h) / gcd - 1;
    return w * h - count * gcd;
}

const getGCD = (a, b) => {
    if (a < b) {
        const temp = a;
        a = b;
        b = temp;
    }
    while (b > 0) {
        const temp = a % b;
        a = b;
        b = temp;
    }
    return a;
};
