function solution(n, t, m, p) {
    let str = "";
    const arr = [];
    let idx = p - 1;
    let currentNumber = 0;
    while (arr.length < t) {
        while (idx >= str.length) {
            str += currentNumber.toString(n);
            currentNumber++;
        }
        arr.push(str[idx]);
        idx += m;
    }
    return arr.join("").toUpperCase();
}
