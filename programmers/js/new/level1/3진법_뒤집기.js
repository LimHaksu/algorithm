function solution(n) {
    return make10(make3reverse(n));
}

function make3reverse(n) {
    let ternary = "";
    while (n > 0) {
        ternary += n % 3;
        n = parseInt(n / 3);
    }
    return ternary;
}

function make10(ternary) {
    let current = 1;
    let ret = 0;
    for (let i = ternary.length - 1; i >= 0; --i) {
        ret += current * parseInt(ternary.charAt(i));
        current *= 3;
    }
    return ret;
}
